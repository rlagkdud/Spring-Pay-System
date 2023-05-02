package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayCancleRequest;
import com.zerobase.convpay.dto.PayCancleResponse;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.PayCancleResult;
import com.zerobase.convpay.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {

    ConveniencePayService conveniencePayService = new ConveniencePayService();
    @Test
    void pay_success() {
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 50);

        // when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        // then
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(50, payResponse.getPayedAmount());
    }

    @Test
    void pay_fail() {
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 1000_001);

        // when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        // then
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0, payResponse.getPayedAmount());
    }

    @Test
    void pay_cancle_success() {
        // given
        PayCancleRequest payCancleRequest = new PayCancleRequest(ConvenienceType.G25, 1000);

        // when
        PayCancleResponse payCancleResponse = conveniencePayService.payCancle(payCancleRequest);

        // then
        assertEquals(PayCancleResult.PAY_CANCLE_SUCCESS, payCancleResponse.getPayCancleResult());
        assertEquals(1000, payCancleResponse.getPayCancledAmount());
    }

    @Test
    void pay_cancle_fail() {
        // given
        PayCancleRequest payCancleRequest = new PayCancleRequest(ConvenienceType.G25, 99);

        // when
        PayCancleResponse payCancleResponse = conveniencePayService.payCancle(payCancleRequest);

        // then
        assertEquals(PayCancleResult.PAY_CANCLE_FAIL, payCancleResponse.getPayCancleResult());
        assertEquals(0, payCancleResponse.getPayCancledAmount());
    }
}