package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Judge;
import racingcar.model.Round;
import racingcar.view.SystemView;

public class GameController {

    private List<Car> cars;
    private int roundNumber;

    public GameController() {
        set();
        game();
        judge();
    }

    public void set() {

        SystemView.promptForCarNames();
        List<String> carNames = CarController.setCars();

        SystemView.promptForRoundNumber();
        roundNumber = RoundController.setRound();

        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.nameOf(carName));
        }
    }

    public void game() {

        SystemView.displayGameResults();

        Round round = Round.carsOf(cars);
        round.playRound(roundNumber);
    }

    public void judge() {

        Judge.determineWinners(cars);
    }

}

