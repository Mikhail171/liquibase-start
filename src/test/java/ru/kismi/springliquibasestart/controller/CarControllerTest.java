package ru.kismi.springliquibasestart.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.kismi.springliquibasestart.domain.dto.CreateCar;
import ru.kismi.springliquibasestart.error.exception.ValidationException;
import ru.kismi.springliquibasestart.service.CarService;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {CarController.class})
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void saveCar1() {
        var createCar = new CreateCar("test", 12L);

        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCar)))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void saveCar2() {
        var createCar = new CreateCar("test23", 12L);

        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCar)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    void saveCar3() {
        var createCar = new CreateCar("test23", 12L);
        doThrow(ValidationException.class)
                .when(carService).veryHardWork(createCar);

        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCar)))
                .andExpect(status().isBadRequest());
    }
}