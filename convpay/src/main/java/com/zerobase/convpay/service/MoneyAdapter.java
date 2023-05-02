package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCancleResult;
import com.zerobase.convpay.type.MoneyUseResult;

public class MoneyAdapter {
    public MoneyUseResult use(Integer payAmount){
        System.out.println("MoneyAdapter.use: "+ payAmount);

        // 너무 큰 금액은 실패, 그외엔 성공
        if(payAmount > 1000_000){
            return MoneyUseResult.USE_FAIL;
        }
        return MoneyUseResult.USE_SUCCESS;

    }
    public MoneyUseCancleResult useCancle(Integer payCancleAmount){
        System.out.println("MoneyAdapter.useCancle: "+ payCancleAmount);

        // 너무 작은 금액은 실패, 그외엔 성공
        if(payCancleAmount < 100){
            return MoneyUseCancleResult.MONEY_USE_CANCLE_FAIL;
        }
        return MoneyUseCancleResult.MONEY_USE_CANCLE_SUCCESS;

    }
}
