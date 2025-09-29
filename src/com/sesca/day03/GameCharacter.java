package com.sesca.day03;

public class GameCharacter {
    // 필드
    private String name;
    private int level;
    private int hp;
    private int maxHp;

    // 생성자
    GameCharacter(String name){
        this.name = name;
        level = 1;
        maxHp = 100;
        hp = 100;
    }


    /// 메서드
    void takeDamage(int damage){
        hp -= damage;

        if(hp < 0){
            hp = 0;
        }

        System.out.printf("[%s]가 [%d]의 피해를 입었습니다! (남은 HP : [%d])", name, damage, hp);
    }
    void recoverHp(int amount){
        hp += amount;

        if(hp > maxHp){
            hp = maxHp;
        }
        System.out.printf("[%s]가 [%d]만큼 회복했습니다! (현재 HP : [%d])", name,amount, hp);
    }
    void levelUp(){
        level += 1;
        maxHp += 20;
        hp = maxHp;
        System.out.printf("레벨 업 ! [%s]의 레벨이 [%d]이 되었습니다! (최대 HP : [%d])", name,level, hp);
    }
    void getCharacterInfo(){
        System.out.printf("[%s]의 현재 상태 : 레벨 [%d], HP [%d] / [%d] ", name,level, hp, maxHp);
    }



}
