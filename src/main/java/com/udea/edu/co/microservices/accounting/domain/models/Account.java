package com.udea.edu.co.microservices.accounting.domain.models;

import java.util.List;

public class Account {


    private AccountNumber accountNumber;

    private Integer accountClass;

    private List<AccountBreakdown> accountBreakdowns;

    public Account(Integer accountClass, List<AccountBreakdown> accountBreakdowns) {
        this.accountNumber = new AccountNumber(01,accountClass,1);;
        this.accountClass = accountClass;
        this.accountBreakdowns = accountBreakdowns;
    }



}
