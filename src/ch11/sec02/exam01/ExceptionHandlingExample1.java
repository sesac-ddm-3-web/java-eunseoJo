package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data){

        try{
            int result = data.length();
            //int result2 = 3 /0;
            System.out.println("문자 수 : " + result);

        }catch(NullPointerException e){
           System.out.println(e.getMessage());
           System.out.println(e.toString());
           // e.printStackTrace();
        }finally {
            System.out.println("마무리 실행.");
        }

    }

    public static void temp(int data){
        try{
            int result = 10 / data;
            System.out.println(result);
        }
        catch(ArithmeticException e){
            System.out.println(e.toString());
        }
        finally {
            System.out.println("항상 실행");
        }
    }

    public static void main(String[] args){
        System.out.println("프로그램 시작");
        printLength(null);
        temp(0);
        System.out.println("프로그램 종료.");
    }
}
