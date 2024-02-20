package ru.kismi.springliquibasestart.mapper;

import org.mapstruct.Mapper;
import ru.kismi.springliquibasestart.domain.dto.CreateCar;
import ru.kismi.springliquibasestart.domain.entity.CarEntity;

@Mapper
public interface CarMapper {

    CarEntity toCarEntity(CreateCar createCar);
}
