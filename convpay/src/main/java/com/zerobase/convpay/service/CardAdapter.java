package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CardUseCancleResult;
import com.zerobase.convpay.type.CardUseResult;

public class CardAdapter {
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
}
