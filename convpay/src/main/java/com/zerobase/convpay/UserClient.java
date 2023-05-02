package com.zerobase.convpay;

import com.zerobase.convpay.dto.PayCancleRequest;
import com.zerobase.convpay.dto.PayCancleResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;

public class UserClient {
    public static void main(String[] args) {
        // '사용자' -> 결제시스템 -> 머니 어댑터
        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // G25 편의점에서 결제 1000원
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // 결제 취소 500원
        PayCancleRequest payCancleRequest = new PayCancleRequest(ConvenienceType.G25, 500);
        PayCancleResponse payCancleResponse = conveniencePayService.payCancle(payCancleRequest);

        System.out.println(payCancleResponse);
    }
}
