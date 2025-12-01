package com.sesca.day04.Problem05;

public class Fish implements Swimable{
    @Override
    public void move(){
        System.out.println("물고기가 움직입니다. ");
    }

    @Override
    public void swim(){
        System.out.println("물고기가 수영합니다.");
    }
}
