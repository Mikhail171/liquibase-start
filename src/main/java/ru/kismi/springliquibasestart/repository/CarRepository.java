package ru.kismi.springliquibasestart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kismi.springliquibasestart.domain.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}