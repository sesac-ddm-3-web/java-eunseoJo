package racing;

import racing.controller.RaceController;
import racing.utils.CarGeneratorImpl;
import racing.utils.NumberGeneratorImpl;
import racing.view.InputView;
import racing.view.OutputView;

public class CarApplication {
    public static void main(String[] args ){

       RaceController raceController = new RaceController(new InputView() ,new OutputView() ,new NumberGeneratorImpl(), new CarGeneratorImpl() );

       raceController.runGame();

    }

}

