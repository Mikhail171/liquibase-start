package ru.kismi.springliquibasestart.service.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.kismi.springliquibasestart.domain.dto.CreateCar;
import ru.kismi.springliquibasestart.domain.entity.CarEntity;
import ru.kismi.springliquibasestart.error.exception.MaxPriceExceededException;
import ru.kismi.springliquibasestart.error.exception.ValidationException;
import ru.kismi.springliquibasestart.mapper.CarMapper;
import ru.kismi.springliquibasestart.repository.CarRepository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@SpringBootTest
class CarServiceImplTest {

    @Autowired
    private CarServiceImpl carService;

    @MockBean
    private CarRepository carRepository;

    @MockBean
    private CarMapper carMapper;

    @Nested
    class VeryHardWork {

        @Test
        void veryHardWork_whenNameLengthMoreThan5_thenThrowValidationException() {
            var createCar = createCar();
            createCar.setName(createCar.getName() + "fdscsd");

            assertThatThrownBy(() -> carService.veryHardWork(createCar))
                    .isInstanceOf(ValidationException.class);
        }

        @Test
        void veryHardWork_whenPriceMoreThan1_thenThrowMaxPriceExceededException() {
            var createCar = createCar();
            createCar.setPrice(2L);

            assertThatThrownBy(() -> carService.veryHardWork(createCar))
                    .isInstanceOf(MaxPriceExceededException.class);
        }

        @Test
        void veryHardWork_happyPath() {
            var createCar = createCar();
            var carEntity = carEntity(createCar);

            doReturn(carEntity)
                    .when(carMapper).toCarEntity(createCar);

            carService.veryHardWork(createCar);

            verify(carRepository, times(1))
                    .save(carEntity);
        }
    }

    private CreateCar createCar() {
        return CreateCar.builder()
                .name("test1")
                .price(1L)
                .build();
    }

    private CarEntity carEntity(CreateCar createCar) {
        return CarEntity.builder()
                .name(createCar.getName())
                .price(createCar.getPrice())
                .build();
    }
}