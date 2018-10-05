package com.udea.edu.co.microservices.accounting.Utils;

import com.udea.edu.co.microservices.accounting.domain.models.AccountBreakdown;
import com.udea.edu.co.microservices.accounting.dtos.AccountBreakdownDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtosToModelsTransformation {

    public List<AccountBreakdown> accountBreakdownDtosToAccountBreakdowns(List<AccountBreakdownDto> accountBreakdownDtos)  {
        return accountBreakdownDtos.stream()
                .map(a -> {
                    AccountBreakdown accountBreakdown = null;
                    try {
                        accountBreakdown = new AccountBreakdown(a.getCategory(), a.getInventoryCode(), a.getCost(), a.getQuantity());

                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    return accountBreakdown;
                }).collect(Collectors.toList());
    }
}
