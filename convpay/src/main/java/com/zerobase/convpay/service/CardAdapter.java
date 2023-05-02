package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CanclePaymentResult;
import com.zerobase.convpay.type.CardUseCancleResult;
import com.zerobase.convpay.type.CardUseResult;
import com.zerobase.convpay.type.PaymentResult;

public class CardAdapter implements PaymentInterface{
    // 1. 인증
    public void authorization(){
        System.out.println("Authorization success");

    }

    // 2. 승인
    public void approval(){
        System.out.println("Approval success");


    }

    // 3. 매입
    public CardUseResult capture(Integer payAmount){
        if(payAmount > 100){
            return CardUseResult.USE_FAIL;
        }
        return CardUseResult.USE_SUCCESS;
    }

    // 4. 매입취소
    public CardUseCancleResult cancleCapture(Integer cancleAmount){
        if(cancleAmount < 1000){
            return CardUseCancleResult.CARD_USE_CANCLE_FAIL;
        }
        return CardUseCancleResult.CARD_USE_CANCLE_SUCCESS;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        CardUseResult cardUseResult = capture(payAmount);
        if(cardUseResult == CardUseResult.USE_FAIL){
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CanclePaymentResult canclePayment(Integer cancleAmount) {
        CardUseCancleResult cardUseCancleResult = cancleCapture(cancleAmount);
        if(cardUseCancleResult == CardUseCancleResult.CARD_USE_CANCLE_FAIL){
            return CanclePaymentResult.CANCLE_PAYMENT_FAIL;
        }
        return CanclePaymentResult.CANCLE_PAYMENT_SUCCESS;

    }
}
