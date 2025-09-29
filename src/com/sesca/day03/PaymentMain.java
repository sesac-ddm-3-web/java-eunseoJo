//package com.sesca.day03;
//
//public class PaymentMain {
//    public static void main(String[] args) {
//        // 다양한 결제 수단 객체 생성
//        Payment creditCard = new CreditCardPayment(10000);
//        Payment bankTransfer = new BankTransferPayment(50000);
//        Payment mobilePay = new MobilePayment(30000);
//
//        // Payment 타입 배열에 모든 결제 정보를 담아 다형성 활용
//        Payment[] payments = {creditCard, bankTransfer, mobilePay};
//
//        double totalAmount = 0;
//        double totalFee = 0;
//
//        System.out.println("## 결제 처리 시작 ##");
//        System.out.println("--------------------");
//
//        // 반복문을 돌면서 각 결제 수단의 processPayment 메서드를 호출
//        for (Payment payment : payments) {
//            payment.processPayment(); // 오버라이딩된 각 클래스의 메서드가 호출됨
//            totalAmount += payment.getAmount(); // 총 결제 금액 누적
//            // 참고: 수수료 계산을 위해 각 클래스에 수수료를 반환하는 메서드를 추가로 구현할 수 있습니다.
//            // 여기서는 간단하게 출력 메시지만 확인합니다.
//        }
//
//        System.out.println("--------------------");
//        System.out.println(">> 총 결제 금액: " + totalAmount + "원");
//        // 총 수수료를 계산하여 출력하는 로직을 추가해볼 수도 있습니다.
//    }
//}
