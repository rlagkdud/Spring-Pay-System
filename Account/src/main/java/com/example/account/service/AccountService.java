package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.exception.AccountException;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.AccountUserRepository;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.example.account.type.AccountStatus.IN_USE;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    private final AccountUserRepository accountUserRepository;
    /**
     * 사용자가 있는지 조회
     * 계좌의 번호를 생성
     * 계좌저장, 계좌 정보 넘기기
     */
    @Transactional
    public Account createAccount(Long userId, Long initBalance){
        // 사용자가 있는지 조회
        AccountUser accountUser = accountUserRepository.findById(userId)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));
        // 계좌의 번호를 생성
        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()
                .map(account -> (Integer.parseInt(account.getAccountNumber()))+1 +"")
                .orElse("1000000000");
        // 계좌저장, 계좌 정보 넘기기
        Account savedAccount = accountRepository.save(
                Account.builder()
                        .accountUser(accountUser)
                        .accountStatus(IN_USE)
                        .accountNumber(newAccountNumber)
                        .balance(initBalance)
                        .registeredAt(LocalDateTime.now())
                        .build()
        );
        return savedAccount;

    }

    @Transactional
    public Account getAccount(Long id){
        if(id < 0){
            throw new RuntimeException("Minus");
        }
       return accountRepository.findById(id).get();
    }
}
