package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CanclePaymentResult;
import com.zerobase.convpay.type.PaymentResult;

public interface PaymentInterface {
    PaymentResult payment(Integer payAmount);
    CanclePaymentResult canclePayment(Integer cancleAmount);
}
