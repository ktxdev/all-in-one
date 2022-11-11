package com.ktxdev.allinone.internal.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CreateReminderCommand {
    @NotNull(message = "Description should be provided")
    private String description;
    private String notes;
    @NotNull(message = "Date should be provided")
    @JsonFormat(timezone = "Africa/Harare", locale = "en_ZW", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(timezone = "Africa/Harare", locale = "en_ZW", shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime time;
}
