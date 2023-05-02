package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethod;

public class PayCancleRequest {
    // 편의점 종류
    ConvenienceType convenienceType;

    //결제 취소금액
    Integer payCancleAmount;

    public PayCancleRequest( ConvenienceType convenienceType, Integer payCancleAmount) {
        this.convenienceType = convenienceType;
        this.payCancleAmount = payCancleAmount;
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
