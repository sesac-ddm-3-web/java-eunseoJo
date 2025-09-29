package com.sesca.day03;

public class Furniture extends Item {

    Furniture(String name , int price){
        super(name, price);

    }

    @Override
    public int getFinalPrice() {
        shippingPrice = (int)(3000 + price * 0.05);
        return price + shippingPrice;
    }
}
