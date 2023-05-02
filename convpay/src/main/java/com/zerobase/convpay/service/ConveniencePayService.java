package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.*;
import com.zerobase.convpay.dto.PayCancleRequest;
import com.zerobase.convpay.dto.PayCancleResponse;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();

    public PayResponse pay(PayRequest payRequest) {
        CardUseResult cardUseResult;
        MoneyUseResult moneyUseResult;

        if(payRequest.getPayMethod() == PayMethod.CARD){
            cardAdapter.authorization();
            cardAdapter.approval();
            cardUseResult = cardAdapter.capture(payRequest.getPayAmount());
        } else{
            moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());
        }

        if (cardUseResult == CardUseResult.USE_FAIL ||
                moneyUseResult == MoneyUseResult.USE_FAIL) {
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
