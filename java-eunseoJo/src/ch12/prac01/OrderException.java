package ch12.prac01;

public class OrderException extends Exception  {
    public OrderException(){

    }

    public OrderException(String message){
        super(message);
    }
}

class OutOfStockException extends OrderException{
    public OutOfStockException(){

    }

    public OutOfStockException(String message){
        super(message);
    }
}

class  InsufficientBalanceException  extends OrderException {
    public InsufficientBalanceException(){

    }
    public InsufficientBalanceException(String message){
        super(message);
    }
}