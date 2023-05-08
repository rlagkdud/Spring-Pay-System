package com.example.account;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@Data
@Slf4j
public class AccountDto {
    private String accountNumber;
    private  String nickname;
    private LocalDateTime registerAt;

    public void logging(){
        log.error("error is occurred");
    }
}

