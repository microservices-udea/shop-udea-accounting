package com.udea.edu.co.microservices.accounting.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class AccountNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private long id;

    Integer accountClass;

    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer concecutive;



}
