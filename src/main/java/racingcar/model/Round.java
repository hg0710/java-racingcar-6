package racingcar.model;

import racingcar.view.RoundView;

import java.util.List;

public class Round {
    private List<Car> cars;

    private Round(List<Car> cars) {
        this.cars = cars;
    }

    public static Round carsOf(List<Car> cars) {
        return new Round(cars);
    }

    public void playRound(int numAttempts) {
        for (int round = 1; round <= numAttempts; round++) {
            for(Car car : cars){
                car.move();
            }
            RoundView.printRoundResults(cars);
        }
    }
}
