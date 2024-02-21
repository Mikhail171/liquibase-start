package ru.kismi.springliquibasestart.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kismi.springliquibasestart.domain.dto.ErrorMessage;
import ru.kismi.springliquibasestart.error.exception.ValidationException;

import java.time.Instant;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ValidationException.class})
    public ErrorMessage methodArgumentNotValidException(ValidationException ex) {
        return ErrorMessage.builder()
                .message(ex.getMessage())
                .date(Instant.now())
                .build();
    }
}