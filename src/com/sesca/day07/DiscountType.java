package com.sesca.day07;

import java.util.function.BiFunction;


public enum DiscountType {
    PERCENTAGE((originalPrice, discountValue) -> {
        System.out.println("퍼센트 할인 적용");
        return originalPrice - (originalPrice * discountValue / 100);
    }),

    FIXED_AMOUNT((originalPrice, discountValue) -> {
        System.out.println("고정 금액 할인 적용");
        return originalPrice - discountValue;
    }),
    PERCENTAGE2((originalPrice, discountValue) -> {
        System.out.println("퍼센트 2배 할인 적용");
        return originalPrice -  (originalPrice  * 2 * discountValue / 100);
    }),
    FIXED2 ((originalPrice, discountValue)->{
        System.out.println("고정금액 2배 할인 적용");
        return originalPrice - 2 * discountValue;
    });

    DiscountType(BiFunction<Long, Long, Long> expression){
        this.expression = expression;
    }

    private BiFunction <Long, Long, Long> expression;

    public long calculate(long originalPrice , long discountValue){
        return this.expression.apply(originalPrice, discountValue);
    }
}

