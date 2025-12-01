package com.sesca.day02;
import  java.util.Scanner;
import java.text.DecimalFormat;

public class problem2 {
    public static  void main(String[] args){
        // input : 원가, 할인율
        // output : 최종 금액 , 적립될 포인트

        // 세자리수
        DecimalFormat df = new DecimalFormat("###,###");
        // 입력
        Scanner sc = new Scanner(System.in);

        System.out.println("상품의 원가를 입력하세요: ");
        int originalPrice = sc.nextInt();

        System.out.println("할인율(%)을 입력하세요 : ");
        float discountRate = sc.nextFloat();

        // 최종 결제 금액, 적립 포인트 계산
        float price = originalPrice * (1 - discountRate /100);
        int totalPrice = (int) (price / 10) * 10;

        int point = totalPrice >= 30000 ? (int) (totalPrice * 0.05) : (int) (totalPrice * 0.01);



        String originStrPrice = df.format(originalPrice);
        String totalStrPrice = df.format(totalPrice);
        String pointStr = df.format(point);


        // 출력
        System.out.println("=========결제 정보 ===========");
        System.out.printf("상품 원가 : %s원\n" , originStrPrice);
        System.out.printf("할인율 : %.1f%%\n" ,discountRate );
        System.out.println("============================");
        System.out.printf("Final Price : %s won\n" , totalStrPrice);
        System.out.println("Point will be " + pointStr + " point");






    }
}
