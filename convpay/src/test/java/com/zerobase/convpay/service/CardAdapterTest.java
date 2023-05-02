package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CardUseCancleResult;
import com.zerobase.convpay.type.CardUseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdapterTest {

    private CardAdapter cardAdapter = new CardAdapter();
    @Test
    void capture_success() {
        // given
        Integer payAmount = 99;
        // when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);
        // then
        assertEquals(CardUseResult.USE_SUCCESS, cardUseResult);
    }
    @Test
    void capture_fail () {
        // given
        Integer payAmount = 101;
        // when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);
        // then
        assertEquals(CardUseResult.USE_FAIL, cardUseResult);
    }

    @Test
    void cancleCapture_success() {
        // given
        Integer cancleAmount = 1000;
        // when
        CardUseCancleResult cardUseCancleResult = cardAdapter.cancleCapture(cancleAmount);
        // then
        assertEquals(CardUseCancleResult.CARD_USE_CANCLE_SUCCESS, cardUseCancleResult);
    }

    @Test
    void cancleCapture_fail() {
        // given
        Integer cancleAmount = 999;
        // when
        CardUseCancleResult cardUseCancleResult = cardAdapter.cancleCapture(cancleAmount);
        // then
        assertEquals(CardUseCancleResult.CARD_USE_CANCLE_FAIL, cardUseCancleResult);
    }
}