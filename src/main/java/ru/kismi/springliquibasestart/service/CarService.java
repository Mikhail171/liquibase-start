package ru.kismi.springliquibasestart.service;

import ru.kismi.springliquibasestart.domain.dto.CreateCar;

public interface CarService {

    void createCar(CreateCar createCar);

    void veryHardWork(CreateCar createCar);
}
