package racing.controller;

import racing.utils.CarGenerator;
import racing.view.InputView;
import racing.utils.NumberGenerator;
import racing.domain.Car;
import racing.view.OutputView;

import java.util.List;

public class RaceController {

    private final InputView inputview;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private final CarGenerator carGenerator;

    public RaceController(InputView inputview,OutputView outputView, NumberGenerator numberGenerator, CarGenerator carGenerator) {
        this.inputview = inputview;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
        this.carGenerator = carGenerator;
    }


    // 게임을 실행하는 함수
    public void runGame(){
        /// 입력
       outputView.printAskCarCount();
       int carCount = inputview.readCarCount();
       outputView.printAskMoveCount();
       int turnCount = inputview.readMoveCount();

        /// 턴 처리 및 턴마다 출력
        playTurn(carCount, turnCount);


    }

    // 턴을 진행하는 함수
    public void playTurn(int carCount, int turnCount){
        // 차 생성
        List<Car> cars = carGenerator.createCars(carCount);


        // 초기 상태 출력
        outputView.printStart();
        outputView.printAllCarsStatus(cars);

        // 각 턴을 진행
        // 각 턴마다 모든 자동차를 움직인다
        // 각 턴마다 모든 자동차의 상태를 출력한다
        for(int turn = 0; turn < turnCount; turn++){
            outputView.printCurrentTurn(turn);

            // 모든 자동차를 움직인다
            moveAllCars(cars);

            // 모든 자동차의 상태 출력
            outputView.printAllCarsStatus(cars);

        }

    }

    public void moveAllCars(List<Car> cars){
        for(Car car : cars){
            car.move(numberGenerator);
        }
    }





}
