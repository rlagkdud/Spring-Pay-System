package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayCancleResult;

public class PayCancleResponse {
    PayCancleResult payCancleResult;

    Integer payCancledAmount;

    public PayCancleResponse(PayCancleResult payCancleResult, Integer payCancledAmount) {
        this.payCancleResult = payCancleResult;
        this.payCancledAmount = payCancledAmount;
    }

    public PayCancleResult getPayCancleResult() {
        return payCancleResult;
    }

    public void setPayCancleResult(PayCancleResult payCancleResult) {
        this.payCancleResult = payCancleResult;
    }

    public Integer getPayCancledAmount() {
        return payCancledAmount;
    }

    public void setPayCancledAmount(Integer payCancledAmount) {
        this.payCancledAmount = payCancledAmount;
    }
}
