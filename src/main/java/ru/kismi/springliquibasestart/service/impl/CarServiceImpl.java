package ru.kismi.springliquibasestart.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kismi.springliquibasestart.domain.dto.CreateCar;
import ru.kismi.springliquibasestart.error.exception.MaxPriceExceededException;
import ru.kismi.springliquibasestart.error.exception.ValidationException;
import ru.kismi.springliquibasestart.mapper.CarMapper;
import ru.kismi.springliquibasestart.repository.CarRepository;
import ru.kismi.springliquibasestart.service.CarService;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    @Transactional
    public void createCar(CreateCar createCar) {
        carRepository.save(carMapper.toCarEntity(createCar));
    }

    public void veryHardWork(CreateCar createCar) {
        if (createCar.getName().length() > 5) {
            throw new ValidationException("Validation exception");
        }

        if (createCar.getPrice() > 1) {
            throw new MaxPriceExceededException("MaxPriceExceededException");
        }

        log.info("Success!");
    }
}