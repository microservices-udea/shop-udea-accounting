package com.udea.edu.co.microservices.accounting.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private long id;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonProperty("account_number")
    @ApiModelProperty(hidden = true)
    private AccountNumber accountNumber;

    @ApiModelProperty(hidden = true)
    @JsonProperty("account_class")
    private String accountClass;

    @NotNull
    @JsonProperty("detail")
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AccountBreakdown> accountBreakdowns;


}
