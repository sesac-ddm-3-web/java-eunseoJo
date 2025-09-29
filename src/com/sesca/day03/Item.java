package com.sesca.day03;

public class Item {
    //필드
    String name;
    int price;
    static int shippingPrice = 3000;

    //생성자
    Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    //메서드
    void displayInfo(){
       System.out.println("상품명 : " + name + "가격 : " + price);
    }
    int getFinalPrice(){
        return shippingPrice + price;
    }

}
