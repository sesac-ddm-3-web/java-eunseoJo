package com.sesca.day03;

public class ShippingMain {
    public static void main(String[] args) {
        // 다양한 종류의 상품 객체 생성
        Item book = new Item("자바의 정석", 30000);
        Furniture chair = new Furniture("편한 의자", 100000);
        Grocery apple = new Grocery("유기농 사과", 15000);

        // Item 타입 배열에 모든 상품을 담아 다형성 활용
        Item[] cart = {book, chair, apple};

        int totalPayment = 0;

        System.out.println("## 장바구니 ##");
        // 반복문을 돌면서 각 상품의 정보를 출력하고 최종 결제 금액을 계산
        for (Item item : cart) {
            item.displayInfo();
            int finalPrice = item.getFinalPrice();
            System.out.println("최종 결제 금액: " + finalPrice + "원");
            totalPayment += finalPrice;
            System.out.println("--------------------");
        }

        System.out.println(">> 총 결제 예정 금액: " + totalPayment + "원");
    }
}

