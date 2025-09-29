package com.sesca.day03;

import java.util.Scanner;
import java.util.Random;

public class problem03 {
    public static  void main(String[] args){
        // 초기 주어진 값 : 총페이지, 정답페이지, 기회
        int totalPage = 1000;
        int answerPage = (int) (Math.random() * 100 + 1) ; // 정답은 랜덤으로 선정
        int chance = 10; // 10번의 기회


        // 나중에 메서드로 빼자 - 실행
        while(chance > 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("정답 페이지를 맞춰보세요 ! 페이지를 입력하세요(1~1000 단 기회는 10번):  ");
            int guessPage  = sc.nextInt();

            // 조건에 따라 분기
            // 같을때
            if(guessPage == answerPage){
                System.out.println("정답입니다. 축하합니다! ");
                System.out.println("축하합니다!" + (10 - chance + 1) + "번만에 찾았습니다.");
                return;
            }
            // 작을때
            else if(guessPage < answerPage){
                System.out.println("더 뒷장입니다. up!");
            }
            //클때
            else{
                System.out.println("더 앞장입니다, Down!");
            }

            chance--;
        }

        System.out.println("YOU LOSE! ");
        System.out.println("ANSWER IS... " + answerPage);

    }
}
