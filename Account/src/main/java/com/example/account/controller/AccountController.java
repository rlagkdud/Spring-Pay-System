package com.example.account.controller;

import com.example.account.domain.Account;
import com.example.account.dto.CreateAccount;
import com.example.account.service.AccountService;
import com.example.account.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final RedisService redisService;

    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request request
            ){
        accountService.createAccount(
                request.getUserId(),
                request.getInitBalance()
        );
        return "success";
    }

    @GetMapping("/get-lock")
    public String getLock(){
        return redisService.getLock();
    }

    @GetMapping("/account/{id}")
    public Account getAccount( @PathVariable Long id){
        return accountService.getAccount(id);
    }
}
