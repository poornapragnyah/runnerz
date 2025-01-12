package com.poornapragnyah.runnerz.Run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(

    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime endedOn,
    @Positive
    Integer miles,
    Location location
){
    public Run {
        if (startedOn.isAfter(endedOn)) {
            throw new IllegalArgumentException("Run cannot end before it starts");
        }
    }
}
