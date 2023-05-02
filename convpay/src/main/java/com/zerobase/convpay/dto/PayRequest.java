package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethod;

public class PayRequest {
    // 결제 수단
    PayMethod payMethod;

    // 편의점 종류
    ConvenienceType convenienceType;
    // 결제 금액
    Integer payAmount;

    public PayRequest(ConvenienceType convenienceType, Integer payAmount) {
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public PayRequest(PayMethod payMethod, ConvenienceType convenienceType, Integer payAmount) {
        this.payMethod = payMethod;
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }
}
