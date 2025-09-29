package com.sesca.day02;
import java.util.Scanner;
import java.text.DecimalFormat;

public class problem01 {
    // input : 원금 , 원이율 , 예치기간
    // output : 총액, 이자 수익

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###,###");
        // 입력
        System.out.println("원금을 입력하세요 : ");
        int principal =  sc.nextInt();

        System.out.println("연이율(%)을 입력하세요 : ");
        float interestRate = sc.nextFloat();

        System.out.println("예치기간(년)을 입력하세요: ");
        int years = sc.nextInt();

        // 총액, 이자 수익 계산
        long simpleInterest = (long) (principal * (interestRate / 100) * years);
        int total = principal + (int) simpleInterest; // total int -> principal total




        // 출력

        String principalStr = df.format(principal);
        String simpleInterestStr = df.format(simpleInterest);
        String totalPrice = df.format(total);

        System.out.println("========최종 계산 결과=========");
        System.out.printf("원금 : %,d원\n"  ,principal );
        System.out.println("연이율 : " + interestRate + "%");
        System.out.println("============================");

        System.out.println("총이자수익: " + simpleInterestStr + "원");
        System.out.println("최종 수령액 : " + totalPrice + "원");
    }
}
