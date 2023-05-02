package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;

public class DiscountByPayMethod implements DiscountInterface {
    @Override
    public Integer getDiscountAmount(PayRequest payRequest) {
        switch (payRequest.getPayMethod()) {
            case MONEY:
                return payRequest.getPayAmount() * 7 / 10;
            case CARD:
                return payRequest.getPayAmount();
        }
        return payRequest.getPayAmount();
    }
}
