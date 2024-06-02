package com.example.bankapp.Mapper;

import com.example.bankapp.DTO.AccountDto;
import com.example.bankapp.Entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getAccountNumber(),
                accountDto.getAccountHolderName(),
                accountDto.getAccountType(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getAccountNumber(),
                account.getAccountHolderName(),
                account.getAccountType(),
                account.getBalance()
        );
        return accountDto;
    }
}
