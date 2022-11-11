package com.ktxdev.allinone.internal.service.impl;

import com.ktxdev.allinone.internal.command.CreateReminderCommand;
import com.ktxdev.allinone.internal.command.UpdateReminderCommand;
import com.ktxdev.allinone.internal.domain.Reminder;
import com.ktxdev.allinone.internal.exceptions.DuplicateRecordException;
import com.ktxdev.allinone.internal.mapper.ReminderMapper;
import com.ktxdev.allinone.internal.repository.ReminderRepository;
import com.ktxdev.allinone.internal.service.ReminderService;
import com.ktxdev.allinone.internal.utils.Validations;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl extends BaseServiceImpl<Reminder, CreateReminderCommand, UpdateReminderCommand>
        implements ReminderService {
    private final ReminderMapper mapper;
    private final ReminderRepository repository;

    public ReminderServiceImpl(ReminderMapper mapper, ReminderRepository repository) {
        super(repository);
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Reminder create(CreateReminderCommand command) {
        Validations.validate(command);

        if (repository.existsByDescription(command.getDescription())) {
            throw new DuplicateRecordException("Reminder with description: '{}' already exists.", command.getDescription());
        }

        Reminder reminder = mapper.toDomain(command);
        return repository.save(reminder);
    }

    @Override
    public Reminder update(UpdateReminderCommand command) {
        Validations.validate(command);

        Reminder persistedReminder = findById(command.getId());

        if (repository.existsByDescriptionAndIdIsNot(command.getDescription(), command.getId())) {
            throw new DuplicateRecordException("Reminder with description: '{}' already exists.", command.getDescription());
        }

        mapper.update(persistedReminder, command);

        return repository.save(persistedReminder);
    }
}
