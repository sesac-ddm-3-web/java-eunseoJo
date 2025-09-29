package com.sesca.day04.Problem05;

public class Warrior implements Movable, Attackable{


    @Override
    public void move(){
        System.out.println("전사가 움직입니다. ");
    }

    @Override
    public void attack(){
        System.out.println("전사가 공격을 합니다.");
    }
}
