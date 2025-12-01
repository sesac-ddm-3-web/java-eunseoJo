package Assignment.Collectioin_Lamda_Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Iterator;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + "(" + score + "점)";
    }
}

public class StudentManager {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("김철수", 85),
                new Student("이영희", 92),
                new Student("박민서", 78),
                new Student("정지원", 95),
                new Student("최유진", 88)
        );

        // TODO 1: 80점 이상 학생들만 필터링하여 출력
        System.out.println("==80점 이상 학생들==");
        List students1 = students.stream()
                .filter(student-> student.getScore() >= 80)
                .toList();

//        // how1 - 이터레이터 사용해서 출력해보기
//        Iterator<Student> iterator = students1.iterator();
//        while(iterator.hasNext()){
//            Student student = iterator.next();
//            String studentName = student.getName();
//            System.out.println("student " + studentName);
//        }

        // how2 - 함수사용해서 출력
        students.stream()
                .filter(student-> student.getScore() >= 80)
                .forEach(student -> System.out.println("student - " + student.getName()));

        // TODO 2: 전체 학생 평균 점수 계산 (Optional<Double> 활용)
        System.out.println("==전체학생 평균 점수==");
        OptionalDouble meanScore = students.stream()
                .mapToInt(student -> student.getScore())
                .average();

        System.out.println("평균 점수 : " + meanScore.getAsDouble());



        // TODO 3: 점수 기준 내림차순 정렬 후 출력
        System.out.println("==점수기준 내림차순 정렬==");
        students.stream()
                .sorted((s1,s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .forEach(student-> System.out.println(student.getName() + " - 점수 : " + student.getScore()));


        // TODO 4: 이름으로 학생 찾기 (Optional 반환)
        // "박민수" 찾기 -> 있으면 점수 출력, 없으면 "학생을 찾을 수 없습니다" 출력
        System.out.println("==이름으로 학생 찾기 ==");
        Optional<Student> isMS = students.stream()
                .filter(s-> s.getName().equals("박민수"))
                .findFirst();

       isMS.ifPresent(student->{
          System.out.println("박민수의 점수 : " + student.getScore() + "점");
       });

       if(!isMS.isPresent()){
           System.out.println("학생을 찾을 수 없습니다");
       }

    }
}