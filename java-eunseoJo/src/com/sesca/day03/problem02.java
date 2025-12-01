package com.sesca.day03;

public class problem02 {
    public static void main(String[] args) {
        int sum = 0;
        // 초기화, 조건식, 증감식이 한 줄에 명확하게 표현됨
//        for (int i = 1; i <= 5; i++) {
//            sum += i;
//        }
        int i = 1;
        while(i <= 5){
            sum += i;
            i++;
        }
        System.out.println("1부터 5까지의 합: " + sum); // 결과: 15
    }


}
