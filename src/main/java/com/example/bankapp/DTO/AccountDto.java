package com.example.bankapp.DTO;

import lombok.*;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long accountNumber;
    private String accountHolderName;
    private String accountType;
    private Double balance;
}
