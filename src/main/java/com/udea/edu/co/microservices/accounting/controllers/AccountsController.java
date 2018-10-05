package com.udea.edu.co.microservices.accounting.controllers;



import com.udea.edu.co.microservices.accounting.dtos.AccountDto;
import com.udea.edu.co.microservices.accounting.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/accounts")
public class AccountsController {

    @Autowired
    AccountsRepository repository;

    @GetMapping
    public Iterable<AccountDto> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{account}")
    public AccountDto find(@PathVariable("account") String account) {
        return repository.findByAccountNumber(account);
    }


    @PostMapping(consumes = "application/json")
    public AccountDto create(@RequestBody AccountDto account) {
        return repository.save(account);
    }
}
