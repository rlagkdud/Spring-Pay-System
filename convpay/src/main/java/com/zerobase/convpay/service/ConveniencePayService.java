package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.*;
import com.zerobase.convpay.dto.PayCancleRequest;
import com.zerobase.convpay.dto.PayCancleResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ConveniencePayService {
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap = new HashMap<>();
    private final DiscountInterface  discountInterface;
    //private final DiscountInterface  discountInterface = new DiscountByPayMethod();
    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountByConvenience) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethodType(),
                        paymentInterface
                )
        );
        this.discountInterface = discountByConvenience;
    }

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethod());

        Integer discountedAmount = discountInterface.getDiscountAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountedAmount);

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        // success case
        return new PayResponse(PayResult.SUCCESS, discountedAmount);

    }

    public PayCancleResponse payCancle(PayCancleRequest payCancleRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancleRequest.getPayMethodType());

        CanclePaymentResult canclePayment = paymentInterface.canclePayment(payCancleRequest.getPayCancleAmount());

        if(canclePayment == CanclePaymentResult.CANCLE_PAYMENT_FAIL){
            return new PayCancleResponse(PayCancleResult.PAY_CANCLE_FAIL, 0);
        }
        // success case
        return new PayCancleResponse(PayCancleResult.PAY_CANCLE_SUCCESS, payCancleRequest.getPayCancleAmount());
    }
}
