package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCancleResult;
import com.zerobase.convpay.type.MoneyUseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyAdapterTest {

    MoneyAdapter moneyAdapter = new MoneyAdapter();
    @Test
    void money_use_fail () {
        // given
        Integer payAmount = 1000_001;
        
        // when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        // then
        assertEquals(MoneyUseResult.USE_FAIL, moneyUseResult);
    }

    @Test
    void money_use_success () {
        // given
        Integer payAmount = 1000_000;

        // when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        // then
        assertEquals(MoneyUseResult.USE_SUCCESS, moneyUseResult);
    }

    @Test
    void money_use_cancle_success () {
        // given
        Integer payCancleAmount = 101;
        // when
        MoneyUseCancleResult moneyUseCancleResult = moneyAdapter.useCancle(payCancleAmount);
        // then
        assertEquals(MoneyUseCancleResult.MONEY_USE_CANCLE_SUCCESS, moneyUseCancleResult);
    }

    @Test
    void money_use_cancle_fail () {
        // given
        Integer payCancleAmount = 99;
        // when
        MoneyUseCancleResult moneyUseCancleResult = moneyAdapter.useCancle(payCancleAmount);
        // then
        assertEquals(MoneyUseCancleResult.MONEY_USE_CANCLE_FAIL, moneyUseCancleResult);
    }


}