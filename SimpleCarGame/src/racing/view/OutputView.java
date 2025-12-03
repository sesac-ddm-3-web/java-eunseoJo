package racing.view;

import racing.domain.Car;

import java.util.List;

public class OutputView {

    public void printAskCarCount() {
        System.out.println("몇대의 자동차?");
    }

    public void printAskMoveCount() {
        System.out.println("시도할 횟수는?");
    }

    public void printCurrentTurn(int curr){
        System.out.println("현재 턴은 " +  (curr+1));
    }

    public void printAllCarsStatus(List<Car> cars){
        for(Car car : cars){
            printCarByStatus(car);
        }

    }

    public void printCarByStatus(Car car){

        for(int i = 0; i < car.getPosition() + 1; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printStart(){
        System.out.println("게임을 시작합니다! 모든 차량은 시작선에 존재합니다");
    }


}
