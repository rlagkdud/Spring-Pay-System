package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.MoneyUseCancleResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.dto.PayCancleRequest;
import com.zerobase.convpay.dto.PayCancleResponse;
import com.zerobase.convpay.type.PayCancleResult;
import com.zerobase.convpay.type.PayResult;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();

    public PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());

        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        // success case
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());

    }

    public PayCancleResponse payCancle(PayCancleRequest payCancleRequest) {
        MoneyUseCancleResult moneyUseCancleResult = moneyAdapter.useCancle(payCancleRequest.getPayCancleAmount());
        if(moneyUseCancleResult == MoneyUseCancleResult.MONEY_USE_CANCLE_FAIL){
            return new PayCancleResponse(PayCancleResult.PAY_CANCLE_FAIL, 0);
        }
        // success case
        return new PayCancleResponse(PayCancleResult.PAY_CANCLE_SUCCESS, payCancleRequest.getPayCancleAmount());
    }
}
