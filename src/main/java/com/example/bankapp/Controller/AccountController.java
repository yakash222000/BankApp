package com.example.bankapp.Controller;

import com.example.bankapp.DTO.AccountDto;
import com.example.bankapp.Entity.Account;
import com.example.bankapp.Sevice.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    AccountService accountService;

    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    //Add Account REST API
    @PostMapping
    public ResponseEntity<Account> addAccount(AccountDto accountDto) {
        return new ResponseEntity<>(AccountService.createAccount(accountDto), HttpStatus.CREATED);
    }
}
