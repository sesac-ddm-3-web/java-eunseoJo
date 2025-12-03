package racing.domain;

import racing.utils.NumberGenerator;

public class Car {
    // 자동차의 상태
    private int position = 0;

    public Car(){

        this.position = 0;
    }

    public void move(NumberGenerator gameHelper){
        if(gameHelper.generateRandom() >= 4){
            this.position ++;
        }

    }

    public int getPosition(){
        return this.position;
    }
}
