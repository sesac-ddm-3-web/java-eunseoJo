package racing.utils;

import racing.domain.Car;

import java.util.List;

public interface CarGenerator {

    List<Car> createCars(int carCount);
}
