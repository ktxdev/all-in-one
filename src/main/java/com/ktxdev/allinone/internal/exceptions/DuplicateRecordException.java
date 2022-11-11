package com.ktxdev.allinone.internal.exceptions;

import java.text.MessageFormat;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException(String message) {
        super(message);
    }

    public DuplicateRecordException(String format, Object ...args) {
        this(MessageFormat.format(format, args));
    }
}
