package com.udea.edu.co.microservices.accounting.domain.models;

public class AccountNumber {

    Integer group;
    Integer accountClass;
    Integer concecutive;

    public AccountNumber(Integer group, Integer accountClass, Integer concecutive) {
        this.group = group;
        this.accountClass = accountClass;
        this.concecutive = concecutive;
    }

}
