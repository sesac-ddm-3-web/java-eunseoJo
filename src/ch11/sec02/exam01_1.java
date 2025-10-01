package ch11.sec02;

public class exam01_1 {
    void methodA() {
        try {
            System.out.println("A: B를 호출합니다.");
            methodB();
            System.out.println("A: B가 끝났습니다."); // 이 줄은 실행되지 않음
        } catch (Exception e) {
            System.out.println("A: B로부터 예외를 받았습니다.");
        }
    }

    void methodB() {
        try {
            System.out.println("B: 예외가 발생하기 직전입니다.");
            throw new RuntimeException(); // 예외 발생!
        } finally {
            System.out.println("B: finally 블록을 실행합니다.");
        }
    }

    public static void main(String[] args){
        exam01_1 ex = new exam01_1();
        ex.methodA();
    }
}
