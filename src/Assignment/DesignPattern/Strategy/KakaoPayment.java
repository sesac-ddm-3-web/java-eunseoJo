package Assignment.DesignPattern.Strategy;

public class KakaoPayment implements Payment{

    @Override
    public void payment(double amount){
        System.out.printf("카카오페이로 %,.0f원 결제 되었습니다.", amount);
    }
}
