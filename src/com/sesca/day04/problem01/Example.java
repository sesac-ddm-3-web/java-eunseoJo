package com.sesca.day04.problem01;

public class Example {
    public static void main(String[] args) {
        // Shape 인터페이스는 Circle과 Rectangle 객체를 모두 참조할 수 있습니다.
        Shape circle = new Circle(5.0); // 반지름 5
        Shape rectangle = new Rectangle(4.0, 5.0); // 가로 4, 세로 5

        System.out.printf("원의 넓이: %.2f\n", circle.calculateArea());
        System.out.printf("원의 둘레: %.2f\n", circle.calculatePerimeter());

        System.out.printf("직사각형의 넓이: %.1f\n", rectangle.calculateArea());
        System.out.printf("직사각형의 둘레: %.1f\n", rectangle.calculatePerimeter());
    }
}
