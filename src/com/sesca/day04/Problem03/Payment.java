package com.sesca.day04.Problem03;

public interface Payment {
    public abstract void processPayment(double amount);
    default void printReceipt(double amount){
        System.out.println("결제금액 : "  + (int) amount + "원");
    }
    default boolean validateAmount(double amount){
        if(amount >= 0){
            //System.out.println("금액 유효성 통과 :  " + amount + "원");
            return true;
        }
        else{
            return false;
        }
    }


}
