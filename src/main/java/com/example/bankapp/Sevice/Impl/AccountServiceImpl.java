package com.example.bankapp.Sevice.Impl;

import com.example.bankapp.DTO.AccountDto;
import com.example.bankapp.Entity.Account;
import com.example.bankapp.Mapper.AccountMapper;
import com.example.bankapp.Repository.AccountRepository;
import com.example.bankapp.Sevice.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id,double amount){
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        double depositAmount =  (amount + account.getBalance());
        account.setBalance(depositAmount);
        accountRepository.save(account);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto withdraw(Long id,double amount){
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));

        if(amount > account.getBalance()){
            throw new RuntimeException("Insufficient balance");
        }
        double newAmount =  account.getBalance()-amount;
        account.setBalance(newAmount);
        accountRepository.save(account);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts(){
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        accountRepository.deleteById(id);
    }
}
