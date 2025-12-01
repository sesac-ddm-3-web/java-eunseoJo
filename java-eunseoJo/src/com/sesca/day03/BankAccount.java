package com.sesca.day03;

import java.text.DecimalFormat;

public class BankAccount {

    // 필드
    private String accountNumber;
    private String ownerNumber;
    private long balance;

    // 생성자
    BankAccount(String accountNumber, String ownerNumber){
        this.accountNumber = accountNumber;
        this.ownerNumber = ownerNumber;
        balance = 0;
    }
    ///  메서드
    // 잔액 증가
    void deposit(long amount){
        DecimalFormat df = new DecimalFormat("###,###");
        if(amount < 0){
            System.out.println("유효하지 않은 금액.");
            return;
        }
         balance += amount;
        System.out.println("입급 후 잔액 : " +  df.format(balance) +"원");
    }
    // 잔액 감소
    void withdraw(long amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        // 출금금액 마이너스
        if (amount < 0) {
            System.out.println("0원보다 작은 금액 출금 불가!");
            return;
        }
        // 현재 잔액보다 큰 금액 출금
        else if (amount > balance){
            System.out.println("잔액이 부족합니다.");
        }
        else{
            balance -= amount;
            System.out.println("출금 후 잔액 : " +  df.format(balance) +"원");
        }
    }

    void getBalanceInfo(){
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("계좌번호 > " + accountNumber);
        System.out.println("예금주 > " + ownerNumber);
        System.out.println("현재 잔액 > " + df.format(balance) + "원");

    }

    //유효성 검사 및 에러 발생
    private void checkValidation(){

    }
}
