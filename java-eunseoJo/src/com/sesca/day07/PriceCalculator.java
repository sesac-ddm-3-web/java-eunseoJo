package com.sesca.day07;

public class PriceCalculator {

    /**
     * 원가, 할인 값, 할인 종류를 받아 최종 가격을 계산한다.
     *
     * @param originalPrice 원가
     * @param discountValue 할인 값 (퍼센트 또는 고정 금액)
     * @param type          할인 종류 (DiscountType Enum)
     * @return 최종 가격
     */

    public long calculate(long originalPrice, long discountValue, DiscountType type) {
        long discountedPrice = type.calculate(originalPrice, discountValue);

//        // 타입에 따라 분기하여 할인 로직을 적용
//        if (type == DiscountType.PERCENTAGE) {
//            // 퍼센트 할인 계산
//
//            return type.calculate(originalPrice, discountValue);
//
//        } else if (type == DiscountType.FIXED_AMOUNT) {
//            // 고정 금액 할인 계산
//
//            return type.calculate(originalPrice, discountValue);
//        }
        // 만약 새로운 할인 타입이 추가되면, 여기에 else if 문을 계속 추가해야 한다.

        // 최종 가격이 0보다 작으면 0으로 처리
        return Math.max(0, discountedPrice);
    }
}

