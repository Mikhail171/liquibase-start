package ru.kismi.springliquibasestart.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ErrorMessage {

    private String message;

    private Instant date;
}