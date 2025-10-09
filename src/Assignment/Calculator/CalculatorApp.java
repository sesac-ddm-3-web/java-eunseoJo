package Assignment.Calculator;
import java.util.*;

public class CalculatorApp {
    Scanner scanner = new Scanner(System.in);
    SimpleCalculator calculator = new SimpleCalculator();
    // key : 연산식, Value : 결과값
    Map<String, Double> DB = new LinkedHashMap<>();

    private void print_command(){
        System.out.println("==계산기 프로그램 실행==");
        System.out.println("1. 조회");
        System.out.println("2. 계산(단 띄어쓰기로 입력) ");
        System.out.println("3. 종료");

    }

    public void save(String str, Double result){
        this.DB.put(str,result);
    }

    public void run(){
        while(true){
            // 선택지 출력
            print_command();

            // 선택에 따라 처리
            String choice = scanner.nextLine();
            switch(choice){

                case "1":
                    DB.forEach((key,value) -> {
                        System.out.println(key + " = " + value);
                    });
                    break;

                case "2":
                    String expression = scanner.nextLine();
                    double result = calculator.calculate(expression);
                    save(expression, result);
                    break;

                case "3":
                    System.exit(0);
            }
        }
    }


}
