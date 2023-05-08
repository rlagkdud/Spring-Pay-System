package com.example.account;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto {
    private String accountNumber;
    private  String nickname;
    private LocalDateTime registerAt;
}

