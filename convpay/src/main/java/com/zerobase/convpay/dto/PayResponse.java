package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayResult;

public class PayResponse {
    // 결제 결과
    PayResult payResult;
    // 성공금액
    Integer payedAmount;

    public PayResponse(PayResult payResult, Integer payedAmount) {
        this.payResult = payResult;
        this.payedAmount = payedAmount;
    }

    public PayResult getPayResult() {
        return payResult;
    }

    public void setPayResult(PayResult payResult) {
        this.payResult = payResult;
    }

    public Integer getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Integer payedAmount) {
        this.payedAmount = payedAmount;
    }
}
