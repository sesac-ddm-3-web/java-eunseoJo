package study;

import java.util.ArrayList;
import java.util.List;

public class finalExample {
    public static void main(String[] args) {
        // myList 변수는 final입니다.
        final List<String> myList = new ArrayList<>();
        // final List<String> myList = List.of("banana", "apple");

        // final 키워드는 새로운 객체와의 연결이 불변이라는 의미

        // (1) myList가 가리키는 리스트 객체의 내용을 변경
        myList.add("Apple");
        myList.add("Banana");
        System.out.println(myList); // [Apple, Banana] 출력

        // (2) myList 변수에 새로운 리스트 객체를 재할당
        // myList = new ArrayList<>(); // <-- 컴파일 에러 발생!
    }
}



