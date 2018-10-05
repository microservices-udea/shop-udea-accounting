package com.udea.edu.co.microservices.accounting.Infraestructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.edu.co.microservices.accounting.Utils.DtosToModelsTransformation;
import com.udea.edu.co.microservices.accounting.domain.models.Account;
import com.udea.edu.co.microservices.accounting.domain.models.AccountBreakdown;
import com.udea.edu.co.microservices.accounting.dtos.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;
import java.util.List;

public class KafkaOrderPaidEvent implements EventConsumer {

    @Autowired
    DtosToModelsTransformation dtosToModelsTransformation;

    @Override
    @KafkaListener(topics = "orderTopic")
    public void processEvent(String message) {
        System.out.println("event:" + message);
        //TODO
        // filter message before to transform

        try {
            AccountDto accountDto = new ObjectMapper()
                    .readerFor(AccountDto.class).readValue(message);

            List<AccountBreakdown> accountBreakdowns = dtosToModelsTransformation
                    .accountBreakdownDtosToAccountBreakdowns(accountDto.getAccountBreakdownDtos());
            Account account = new Account(Integer.valueOf(accountDto.getAccountClass()), accountBreakdowns);
            System.out.println(account);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
