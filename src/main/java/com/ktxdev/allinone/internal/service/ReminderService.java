package com.ktxdev.allinone.internal.service;

import com.ktxdev.allinone.internal.command.CreateReminderCommand;
import com.ktxdev.allinone.internal.command.UpdateReminderCommand;
import com.ktxdev.allinone.internal.domain.Reminder;

public interface ReminderService extends BaseService<Reminder, CreateReminderCommand, UpdateReminderCommand>  {
}
