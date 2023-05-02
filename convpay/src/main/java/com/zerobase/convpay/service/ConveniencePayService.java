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
        PaymentInterface paymentInterface;
        if(payRequest.getPayMethod() == PayMethodType.CARD){
            paymentInterface = cardAdapter;
        } else{
            paymentInterface = moneyAdapter;
        }

        PaymentResult payment = paymentInterface.payment(payRequest.getPayAmount());

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        // success case
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());

    }

    public PayCancleResponse payCancle(PayCancleRequest payCancleRequest) {
        PaymentInterface paymentInterface;
        if(payCancleRequest.getPayMethodType() == PayMethodType.CARD){
            paymentInterface = cardAdapter;
        } else{
            paymentInterface = moneyAdapter;
        }

        CanclePaymentResult canclePayment = paymentInterface.canclePayment(payCancleRequest.getPayCancleAmount());

        if(canclePayment == CanclePaymentResult.CANCLE_PAYMENT_FAIL){
            return new PayCancleResponse(PayCancleResult.PAY_CANCLE_FAIL, 0);
        }
        // success case
        return new PayCancleResponse(PayCancleResult.PAY_CANCLE_SUCCESS, payCancleRequest.getPayCancleAmount());
    }
}
