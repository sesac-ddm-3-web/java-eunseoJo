package ch12.sec03.exam02;

public class HashCodeTest {
    public static void main(String[] args) {
        System.out.println("연속된 객체의 해시코드 변화 관찰");
        Object prev = new Object();
        System.out.println("객체 1: " + System.identityHashCode(prev));

        for (int i = 2; i <= 10; i++) {
            Object current = new Object();
            System.out.println("객체 " + i + ": " + System.identityHashCode(current));
            // 이전 객체와 주소값 차이가 크지 않다고 가정할 때,
            // 해시코드의 차이를 관찰
            System.out.println("  (이전과의 차이: " +
                    (System.identityHashCode(current) - System.identityHashCode(prev)) + ")");
            prev = current;
        }
    }
}