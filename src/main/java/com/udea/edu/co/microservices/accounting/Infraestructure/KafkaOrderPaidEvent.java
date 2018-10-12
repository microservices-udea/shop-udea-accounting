package com.udea.edu.co.microservices.accounting.Infraestructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.udea.edu.co.microservices.accounting.entities.Account;
import com.udea.edu.co.microservices.accounting.entities.AccountNumber;
import com.udea.edu.co.microservices.accounting.entities.EventMessage;
import com.udea.edu.co.microservices.accounting.repository.AccountsRepository;
import com.udea.edu.co.microservices.accounting.repository.EventMessagessRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
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
    @KafkaListener(topics = "${topic.orders}")
    public void processEvent(String message) {
        System.out.println("event:" + message);
        // filter message before to transform

        String eventType = "";
        try {
            eventType = JsonPath.read(message, jsonPathEventTypeExp);
        } catch (PathNotFoundException e){
            e.printStackTrace();
        }

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
