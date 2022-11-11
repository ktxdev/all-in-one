package com.ktxdev.allinone.internal.repository;

import com.ktxdev.allinone.internal.domain.Reminder;

public interface ReminderRepository extends BaseRepository<Reminder> {
    boolean existsByDescription(String description);
    boolean existsByDescriptionAndIdIsNot(String description, long id);
}
