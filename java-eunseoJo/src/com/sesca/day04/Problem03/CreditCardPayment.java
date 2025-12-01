package com.sesca.day04.Problem03;

public class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount){
        if(validateAmount(amount)){
            System.out.println("금액 유효성 통과 :  " + (int) amount + "원");
            System.out.println("신용카드로 " + (int) amount + "원 " + "결제했습니다.");

            System.out.println("=== 신용카드 영수증 ===");
            printReceipt(amount);

            System.out.println("결제 완료");

        }
    }




}
