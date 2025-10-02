package Assignment.DesignPattern.Strategy;

public class Service {
    private Payment payment;

    public void setPayment(Payment payment){
        this.payment = payment;
    }

    public void pay(double amount){
        System.out.println("결제를 시작합니다....");
        payment.payment(amount);
    }
}
