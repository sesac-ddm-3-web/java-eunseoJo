package com.sesca.day04.Problem03;

public class CashPayment implements Payment{

    @Override
    public void processPayment(double amount){
        if(validateAmount(amount)){

            System.out.println("금액 유효성 통과 :  " + (int) amount + "원");
            System.out.println("현금으로 " + (int ) amount + "원 " + "결제했습니다.");

            System.out.println("=== 현금 영수증 ===");
            printReceipt(amount);

            System.out.println("거스름돈 : 없음");

        }
    }
}
