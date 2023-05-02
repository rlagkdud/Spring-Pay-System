package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class PayCancleRequest {
    // 결제수단 종류
    PayMethodType payMethodType;

    // 편의점 종류
    ConvenienceType convenienceType;

    //결제 취소금액
    Integer payCancleAmount;

    public PayCancleRequest( PayMethodType payMethodType, ConvenienceType convenienceType, Integer payCancleAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payCancleAmount = payCancleAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancleAmount() {
        return payCancleAmount;
    }

    public void setPayCancleAmount(Integer payCancleAmount) {
        this.payCancleAmount = payCancleAmount;
    }
}
