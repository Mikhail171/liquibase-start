package ru.kismi.springliquibasestart.domain.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCar {

    @Size(max = 5)
    private String name;

    private Long price;
}