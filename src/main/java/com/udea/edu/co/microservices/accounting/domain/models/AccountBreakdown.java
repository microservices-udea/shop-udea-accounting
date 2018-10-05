package com.udea.edu.co.microservices.accounting.domain.models;


import java.math.BigDecimal;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountBreakdown {

    private String category;

    private String inventoryCode;

    private BigDecimal cost;

    private Integer quantity;


    public AccountBreakdown(String category, String inventoryCode, BigDecimal cost, Integer quantity) throws IllegalArgumentException{
        this.category = checkIfNullOrEmpty(category);
        this.inventoryCode = checkIfNullOrEmpty(inventoryCode);
        this.cost = cost;
        this.quantity = quantity;
    }


    private String checkIfNullOrEmpty(String content) throws IllegalArgumentException{

        String s = Optional.ofNullable(content)
                .orElseThrow(() -> new IllegalArgumentException("Null Argument for account breakdown creation"));

        if(s.isEmpty()) {
            throw new IllegalArgumentException("Empty Argument for account breakdown creation");
        }

        return s;
    }
}
