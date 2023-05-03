package com.zerobase.convpay;

//import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.dto.PayCancleRequest;
import com.zerobase.convpay.dto.PayCancleResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // '사용자' -> 결제시스템 -> 머니 어댑터
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService =
                applicationContext.getBean("conveniencePayService", ConveniencePayService.class);

        // G25 편의점에서 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // 결제 취소 500원
        PayCancleRequest payCancleRequest = new PayCancleRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
        PayCancleResponse payCancleResponse = conveniencePayService.payCancle(payCancleRequest);

        System.out.println(payCancleResponse);
    }
}
