package racing.utils;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarGeneratorImpl implements CarGenerator {
    @Override
    public List<Car> createCars(int carCount){
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++){
            Car newCar = new Car();
            cars.add(newCar);
        }
        return cars;
    }

}
