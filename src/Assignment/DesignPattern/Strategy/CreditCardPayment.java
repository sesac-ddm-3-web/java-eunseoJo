package Assignment.DesignPattern.Strategy;

public class CreditCardPayment implements Payment{



    @Override
    public void payment(double amount){
        System.out.printf("카드로 %,.0f원 결제 되었습니다.", amount);
    }
}
