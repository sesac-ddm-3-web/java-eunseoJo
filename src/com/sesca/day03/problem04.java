package com.sesca.day03;

public class problem04 {
    public static void main(String[] args) {
        // 1. 리터럴 방식으로 생성 (String Constant Pool에 저장)
        String literal1 = "hello";
        String literal2 = "hello";

        // 2. new 키워드로 인스턴스 생성 (Heap 메모리에 저장)
        String instance1 = new String("hello");
        String instance2 = new String("hello");

        System.out.println("===== 리터럴 비교 =====");
        System.out.println("literal1 == literal2 : ?" + literal1 == literal2);
        System.out.println("literal1.equals(literal2) : ?" + literal1.equals(literal2));
        System.out.println();

        ///  예상 결과
        // true -> false 상수 풀이 힙 안에 존재하니깐 결국 문자열 리터럴도 다르게 생성된다.
        // true

        System.out.println("===== 리터럴과 인스턴스 비교 =====");
        System.out.println("literal1 == instance1 : ?" + literal1 == instance1);
        System.out.println("literal1.equals(instance1) : ?" + literal1.equals(instance1));
        System.out.println();

        ///  예상 결과
        // false
        // true


        System.out.println("===== 인스턴스 비교 =====");
        System.out.println("instance1 == instance2 : ?" + instance1 == instance2);
        System.out.println("instance1.equals(instance2) : ?" + instance1.equals(instance2));
        System.out.println();

        ///  예상 결과
        // false
        // true
    }
}

