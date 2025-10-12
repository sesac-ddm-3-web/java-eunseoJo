package Assignment.Calculator;

import java.util.*;

public class SimpleCalculator implements  Calculator{




    @Override
    public int add(int a, int b){
      return a + b;
    }

    @Override
    public int sub(int a, int b){
       return a - b;
    }

    @Override
    public int mul(int a, int b){
        return a * b;
    }

    @Override
    public double div(int a, int b){
        if(b == 0){
            throw new ArithmeticException("ZERO X");
        }
        return (double)a / b;
    }

    public int priority(String op){
        switch(op){
            case "+":
            case "-":
                return 1;   // 더하기 뺄셈은 우선순위가 낮음
            case "*":
            case "/":
                return 2;   // 곱하기 나누기는 우선순위가 높음
            default:
                return 0;
        }
    }

    @Override
    public double calculate(String str){
        // 0. 스택 준비
        Stack<Double> num = new Stack<>();
        Stack<String> op = new Stack<>();
        double finalResult = 0.0;

        // 1. 문자열 토큰화
        String[] tokens = str.split(" ");

        // 2. 계산 및 저장
        for(int i = 0; i < tokens.length; i++){
            String n = tokens[i];
            // 토큰이 연산자일 경우
            if(n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/")){
                // op 스택이 비어있으면 push
                if(op.isEmpty()){
                    op.push(n);
                }
                // op 스택이 비어있지 않을때 연산자 처리 로직
                else{
                    // 비어있지 않고 , top 우선순위 >= 넣으려는 연산자 일 경우 연산자 처리
                    while(!op.isEmpty() && priority(op.peek()) >= priority(n)){
                        // op 스택에서 연산자를 꺼낸다.
                        String operation = op.pop();
                        // num 스택에서 숫자 2개를 꺼낸다
                        double num2 = num.pop();
                        double num1 = num.pop();
                        // 결과를 처리한 후 저장한다.

                        switch(operation){
                            case "+":
                                finalResult = add((int)num1, (int)num2);
                                num.push(finalResult);
                                break;
                            case "-":
                                finalResult = sub((int)num1, (int)num2);
                                num.push(finalResult);
                                break;
                            case "*":
                                finalResult = mul((int)num1, (int)num2);
                                num.push(finalResult);
                                break;
                            case "/":
                                finalResult = div((int)num1, (int)num2);
                                num.push(finalResult);
                                break;

                        }


                    }
                    // 연산자가 그냥 높을경우
                    op.push(n);
                }
            }
            // 토큰이 숫자일경우
            else{
                double number = Integer.parseInt(n);
                num.push(number);
            }
        }

        // 남아있는 스택 비우기
        while(!op.isEmpty()){
            String operation = op.pop();

            double num2 = num.pop();
            double num1 = num.pop();


            switch(operation){
                case "+":
                    finalResult = add((int)num1, (int)num2);
                    num.push(finalResult);
                    break;
                case "-":
                    finalResult = sub((int)num1, (int)num2);
                    num.push(finalResult);
                    break;
                case "*":
                    finalResult = mul((int)num1, (int)num2);
                    num.push(finalResult);
                    break;
                case "/":
                    finalResult = div((int)num1, (int)num2);
                    num.push(finalResult);
                    break;
            }
        }

        return finalResult;

    }
}
