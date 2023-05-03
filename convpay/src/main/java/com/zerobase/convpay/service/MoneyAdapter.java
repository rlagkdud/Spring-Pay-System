package com.zerobase.convpay.service;

import com.zerobase.convpay.type.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class MoneyAdapter implements PaymentInterface{
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

    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.MONEY;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        MoneyUseResult moneyUseResult = use(payAmount);
        if(moneyUseResult == MoneyUseResult.USE_FAIL){
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CanclePaymentResult canclePayment(Integer cancleAmount) {
        MoneyUseCancleResult moneyUseCancleResult = useCancle(cancleAmount);
        if(moneyUseCancleResult == MoneyUseCancleResult.MONEY_USE_CANCLE_FAIL){
            return CanclePaymentResult.CANCLE_PAYMENT_FAIL;
        }
        return CanclePaymentResult.CANCLE_PAYMENT_SUCCESS;
    }
}
