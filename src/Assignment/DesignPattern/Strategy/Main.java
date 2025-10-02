package Assignment.DesignPattern.Strategy;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        // 신용카드 결제
        service.setPayment(new CreditCardPayment());
        service.pay(10000);

        System.out.println();

        // PayPal 결제 (추가 전략 예시)
        service.setPayment(new KakaoPayment());
        service.pay(25000);

        System.out.println();

        // 계좌이체 결제 (추가 전략 예시)
        service.setPayment(new BankTransferPayment());
        service.pay(50000);
    }
}
