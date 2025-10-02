package ch12.prac01;


// 핵심 로직을 처리하는 서비스 클래스
class OrderService {
    // 인메모리 데이터베이스 (파일 대신 사용)
    private String[] productDb = {"P101:MacBook:2500000:10", "P102:iPhone:1500000:0", "P103:iPad:1000a00:20"};
    private String[] userDb = {"U001:김자바:5000000", "U002:박씨샵:1000000"};

    // 주문 처리 로직
    public int processOrder(String userId, String productId, int quantity) throws OutOfStockException, InsufficientBalanceException, IllegalArgumentException {
        // 1. 상품 찾기 및 파싱
        Product product = null;
        for (String data : productDb) {
            if (data.startsWith(productId + ":")) {
                try {
                    String[] parts = data.split(":");
                    if (parts.length != 4) {// 데이터 형식 오류
                        throw new IllegalArgumentException("데이터 형식 오류가 발생했습니다.");
                    }
                    product = new Product(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("가격이나 재고 파싱이 오류가 발생했습니다.", e);// 가격/재고 파싱 오류
                }
                catch(ArrayIndexOutOfBoundsException e){
                    throw new IllegalArgumentException("배열의 범위를 벗어났습니다.", e);
                }
                break;
            }
        }
        if (product == null){ // 상품 없음
            throw new IllegalArgumentException(product.name + "이라는 상품이 존재하지 않습니다.");
        }

        // 2. 사용자 찾기
        User user = null;
        for (String data : userDb) {
            if (data.startsWith(userId + ":")) {
                String[] parts = data.split(":");
                user = new User(parts[0], parts[1], Integer.parseInt(parts[2]));
                break;
            }
        }
        if (user == null)  {// 사용자 없음
            throw new IllegalArgumentException(user.name + "이라는 사용자가 존재하지 않습니다.");
        }

        // 3. 비즈니스 규칙 검사
        if (product.stock < quantity) {  // 재고 부족
            throw new OutOfStockException( product.name +"의 재고가 부족합니다. ");

        }
        if (user.balance < product.price * quantity) {  // 잔고 부족
            throw new InsufficientBalanceException(user.name + "의 "+"잔고가 부족합니다." + "현재 금액 : " + user.balance + "원");
        }

        // 4. 주문 성공
        product.stock -= quantity;
        user.balance -= product.price * quantity;
        System.out.printf("주문 성공! [%s]님이 [%s] %d개를 구매했습니다. 남은 잔고: %d\n", user.name, product.name, quantity, user.balance);
        return 0; // 성공
    }
}
