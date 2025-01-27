package dev.jmilla.demo.controllers;

import dev.jmilla.demo.model.entities.Car;
import dev.jmilla.demo.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    private final CarService carService = new CarService();

    @GetMapping("/cars")
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("content", "car/list");
        return "layout";
    }

    @GetMapping("/cars/new")
    public String newCarForm(Model model) {
        model.addAttribute("car", new Car("", ""));  // Coche vacío para el formulario
        model.addAttribute("content", "car/new");
        return "layout";
    }

    @PostMapping("/cars")
    public String saveCar(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/cars";  // Redirigir al listado
    }
}
