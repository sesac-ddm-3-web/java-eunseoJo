package Assignment.Calculator;

public interface Calculator {
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    double div(int a, int b);
    // 우선순위 처리 함수
    double calculate(String str);
}
