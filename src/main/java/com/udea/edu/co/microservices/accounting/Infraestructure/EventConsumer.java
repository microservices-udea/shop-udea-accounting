package com.udea.edu.co.microservices.accounting.Infraestructure;

public interface EventConsumer {

    void processEvent(String message);

}
