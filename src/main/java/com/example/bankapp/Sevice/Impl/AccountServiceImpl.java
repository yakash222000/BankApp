package com.example.bankapp.Sevice.Impl;

import com.example.bankapp.DTO.AccountDto;
import com.example.bankapp.Entity.Account;
import com.example.bankapp.Mapper.AccountMapper;
import com.example.bankapp.Repository.AccountRepository;
import com.example.bankapp.Sevice.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(AccountDto accountDto) {
        return null;
    }

    public AccountDto CreateAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
