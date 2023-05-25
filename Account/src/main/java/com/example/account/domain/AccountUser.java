package com.example.account.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AccountUser extends BaseEntity{
    private String name;
}
