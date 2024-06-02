package com.example.bankapp.Sevice;

import com.example.bankapp.DTO.AccountDto;
import com.example.bankapp.Entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto) ;

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

}
