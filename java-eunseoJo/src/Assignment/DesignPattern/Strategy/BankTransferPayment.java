package Assignment.DesignPattern.Strategy;

public class BankTransferPayment implements Payment{

    @Override
    public void payment(double amount){
        System.out.printf("통장결제로 %,.0f원 결제 되었습니다.", amount);
    }
}
