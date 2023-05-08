package com.example.account;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberUtil {

   // private NumberUtil(){}; // 생성자를 private으로 만들어 생성하지 못하게 함.
    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public static Integer minus(Integer a, Integer b) {
        return a - b;
    }
}
