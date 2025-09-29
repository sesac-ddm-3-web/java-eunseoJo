package com.sesca.day03;

public class Grocery extends Item {

    Grocery(String name , int price){
       super(name, price);
    }

    @Override
    public int getFinalPrice() {
        shippingPrice = 5000;
        return price + shippingPrice;
    }
}
