package com.ktxdev.allinone.internal.exceptions;

import java.text.MessageFormat;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String format, Object ...args) {
        this(MessageFormat.format(format, args));
    }
}
