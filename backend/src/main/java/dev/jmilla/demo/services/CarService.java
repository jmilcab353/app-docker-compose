package dev.jmilla.demo.services;

import dev.jmilla.demo.model.entities.Car;
import java.util.ArrayList;
import java.util.List;

public class CarService {

    private static List<Car> cars = new ArrayList<>();

    static {
        // Inicializamos con algunos coches
        cars.add(new Car("Toyota", "Corolla"));
        cars.add(new Car("Ford", "Focus"));
        cars.add(new Car("Honda", "Civic"));
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

}
