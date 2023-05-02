package com.zerobase.convpay.config;

import com.zerobase.convpay.service.*;

import java.util.Arrays;
import java.util.HashSet;

public class ApplicationConfig {

    public ConveniencePayService conveniencePayServiceDiscountByConvenience(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByConvenience()
        );
    }
    public ConveniencePayService conveniencePayServiceDiscountByPayMethod(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByPayMethod()
        );
    }
}
