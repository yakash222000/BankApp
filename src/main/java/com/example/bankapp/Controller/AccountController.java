package com.example.bankapp.Controller;

import com.example.bankapp.DTO.AccountDto;
import com.example.bankapp.Entity.Account;
import com.example.bankapp.Sevice.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get Account by ID
    @GetMapping("/{id}")
    public ResponseEntity getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    //Deposit API
    @PutMapping("/{id}/deposit")
    public ResponseEntity deposit(@PathVariable Long id,@RequestBody HashMap<String,Double> request){
        double amount = request.get("amount");
        AccountDto accountDto= accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity withdraw(@PathVariable Long id,@RequestBody HashMap<String,Double> request){
        double amount = request.get("amount");
        AccountDto accountDto= accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Get All Accounts API
    @GetMapping()
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtos = accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted");
    }
}
