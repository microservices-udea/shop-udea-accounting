package com.udea.edu.co.microservices.accounting.repository;

import com.udea.edu.co.microservices.accounting.dtos.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface AccountsRepository extends JpaRepository<AccountDto, Long>{

    AccountDto findByAccountNumber(String account);

}
