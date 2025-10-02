package ch12.prac01;


// 메인 실행 클래스
public class SHoppingMallV1 {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        try{
            // 시나리오: 김자바(U001)가 MacBook(P101) 1개를 주문한다.
//            System.out.println("---[ CASE 1: 정상 주문 ]---");
//            int status1 = service.processOrder("U001", "P101", 1);
//
//
//            System.out.println("\n---[ CASE 2: 재고 부족 ]---");
//            int status2 = service.processOrder("U001", "P102", 1);
//
//
//            System.out.println("\n---[ CASE 3: 데이터 형식 오류 ]---");
//            int status3 = service.processOrder("U001", "P103", 1);


            System.out.println("\n---[ CASE 4: 잔고 부족 ]---");
            int status4 = service.processOrder("U002", "P101", 1);



        }catch(OutOfStockException e){
            System.out.println(e.getMessage());
        }catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
