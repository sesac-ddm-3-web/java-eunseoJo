package com.sesca.day04.Problem05;

public class Dragon implements Flyable, MagicAttackable{

    @Override
    public void move(){
        System.out.println("드래곤이 움직입니다. ");
    }

    @Override
    public void fly(){
        System.out.println("드래곤이 하늘을 날아갑니다.  ");
    }

    @Override
    public void attack(){
        System.out.println("드래곤이 물리 공격을 합니다");
    }

    @Override
    public void magicAttack(){
        System.out.println("드래곤이 마법 공격을 합니다.");
    }

}
