package com.example.account;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountDtoTest {
    @Test
    void testAccountDto () {
        // given
        AccountDto accountDto = new AccountDto();
        // when
        accountDto.setAccountNumber("123");
        accountDto.setNickname("nick");
        accountDto.setRegisterAt(LocalDateTime.now());
        // then
        assertEquals("123", accountDto.getAccountNumber());
        assertEquals("nick", accountDto.getNickname());
        System.out.println(accountDto.getRegisterAt());
    }

}