package com.ktxdev.allinone.internal.mapper;

import com.ktxdev.allinone.internal.command.CreateReminderCommand;
import com.ktxdev.allinone.internal.command.UpdateReminderCommand;
import com.ktxdev.allinone.internal.domain.Reminder;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReminderMapper {
    Reminder toDomain(CreateReminderCommand command);
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Reminder reminder, UpdateReminderCommand command);
}
