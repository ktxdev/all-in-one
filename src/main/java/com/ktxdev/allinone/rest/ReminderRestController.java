package com.ktxdev.allinone.rest;

import com.ktxdev.allinone.AllInOneConstants;
import com.ktxdev.allinone.internal.command.CreateReminderCommand;
import com.ktxdev.allinone.internal.command.UpdateReminderCommand;
import com.ktxdev.allinone.internal.domain.Reminder;
import com.ktxdev.allinone.internal.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = AllInOneConstants.REMINDERS_API_URL)
public class ReminderRestController {

    private final ReminderService reminderService;

    @PostMapping
    public ResponseEntity<Reminder> create(@RequestBody CreateReminderCommand command,
                                           HttpServletRequest request) {
        Reminder reminder = reminderService.create(command);

        URI uri = ServletUriComponentsBuilder.fromRequest(request)
                .path(String.valueOf(reminder.getId()))
                .build().toUri();

        return ResponseEntity.created(uri)
                .body(reminder);
    }

    @GetMapping
    public ResponseEntity<Page<Reminder>> findAll(@PageableDefault Pageable pageable,
                                                  @RequestParam(value = "search", required = false) String search) {
        return ResponseEntity.ok(reminderService.findAll(search, pageable));
    }

    @PutMapping("{id}")
    public ResponseEntity<Reminder> update(@PathVariable Long id,
                                           @RequestBody UpdateReminderCommand command) {
        command.setId(id);
        return ResponseEntity.ok(reminderService.update(command));
    }

    @GetMapping("{id}")
    public ResponseEntity<Reminder> findById(@PathVariable Long id) {
        return ResponseEntity.ok(reminderService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Reminder> delete(@PathVariable Long id) {
        reminderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
