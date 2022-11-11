package com.ktxdev.allinone.internal.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateReminderCommand extends CreateReminderCommand {
    @JsonIgnore
    private long id;
}
