package com.udea.edu.co.microservices.accounting.Infraestructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.udea.edu.co.microservices.accounting.entities.Account;
import com.udea.edu.co.microservices.accounting.entities.AccountNumber;
import com.udea.edu.co.microservices.accounting.entities.EventMessage;
import com.udea.edu.co.microservices.accounting.repository.AccountsRepository;
import com.udea.edu.co.microservices.accounting.repository.EventMessagessRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

public class KafkaOrderPaidEvent implements EventConsumer {

    @Autowired
    EventMessagessRepository eventMessagessRepository;

    @Autowired
    AccountsRepository accountsRepository;

    String jsonPathEventTypeExp = "$._eventType";
    String jsonPathUuidExp = "$.transactionId";
    String eventOrderPaid = "co.edu.udea.microservices.compensations.events.OrderPaid";
    String assetsAccountingClass = "02";

    @Override
    //@KafkaListener(topics = "orderTopic")
    public void processEvent(String message) {
        System.out.println("event:" + message);
        // filter message before to transform
        String eventType = JsonPath.read(message, jsonPathEventTypeExp);

        if (!"".equals(eventType) && eventOrderPaid.equals(eventType)) {
            String uuid = JsonPath.read(message, jsonPathUuidExp);
            EventMessage eventMessage = new EventMessage(uuid,"orders", eventType,message);
            eventMessagessRepository.save(eventMessage);

            try {
                Account account = new ObjectMapper()
                        .readerFor(Account.class).readValue(message);
                account.setAccountClass(assetsAccountingClass);
                AccountNumber accountNumber= new AccountNumber();
                accountNumber.setAccountClass(Integer.valueOf(assetsAccountingClass));
                account.setAccountNumber(accountNumber);
                accountsRepository.save(account);
                //TODO
                // Commit message

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            //TODO
            // Commit message
        }

    }
}
