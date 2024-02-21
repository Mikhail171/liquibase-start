package ru.kismi.springliquibasestart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kismi.springliquibasestart.domain.dto.CreateCar;
import ru.kismi.springliquibasestart.service.CarService;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/")
    public void saveCar(@RequestBody CreateCar createCar) {
        carService.createCar(createCar);
    }

    @PostMapping("/cars/veryHardWork")
    public void veryHardWork(@RequestBody CreateCar createCar) {
        carService.veryHardWork(createCar);
    }
}