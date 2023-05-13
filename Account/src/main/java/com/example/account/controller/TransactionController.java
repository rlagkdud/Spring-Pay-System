package com.example.account.controller;

import com.example.account.dto.CancelBalance;
import com.example.account.dto.TransactionDto;
import com.example.account.dto.UseBalance;
import com.example.account.exception.AccountException;
import com.example.account.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 잔액 관련 컨트롤러
 * 1. 잔액 사용
 * 2. 잔액 사용 취소
 * 3. 거래 확인
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/transaction/use")
    public UseBalance.Response useBalance(
           @RequestBody @Valid UseBalance.Request request
    ){
        try {
            TransactionDto transactionDto = transactionService.useBalance(request.getUserId(), request.getAccountNumber(), request.getAmount());
            return UseBalance.Response.from(transactionDto);
        } catch (AccountException e){
            log.error("Failed to use balance. ");
            transactionService.saveFailedUseTransaction(
                    request.getAccountNumber(),
                    request.getAmount()
            );

            throw e;
        }
    }

    @PostMapping("/transaction/cancel")
    public CancelBalance.Response cancelBalance(
            @RequestBody @Valid CancelBalance.Request request
    ){
        try {
            TransactionDto transactionDto = transactionService
                    .cancelBalance(request.getTransactionId(), request.getAccountNumber(), request.getAmount());
            return CancelBalance.Response.from(transactionDto);
        } catch (AccountException e){
            log.error("Failed to cancel balance. ");
            transactionService.saveFailedCancelTransaction(
                    request.getAccountNumber(),
                    request.getAmount()
            );

            throw e;
        }
    }
}
