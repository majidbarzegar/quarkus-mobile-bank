package com.bank.mobile.exception;

import lombok.Getter;
import org.jspecify.annotations.NonNull;

@Getter
public class BusinessException extends RuntimeException {
    private final String messageKey;
    private final Integer code;
    private final Object[] args;

    public BusinessException(String messageKey, Integer code, Object... args) {
        this.messageKey = messageKey;
        this.code = code;
        this.args = args;
    }

    public BusinessException(String messageKey, Integer code) {
        this.messageKey = messageKey;
        this.code = code;
        this.args = null;
    }

    public BusinessException(@NonNull ExceptionMessage exceptionMessage, Object... args) {
        this.messageKey = exceptionMessage.getMessageKey();
        this.code = exceptionMessage.getCode();
        this.args = args;
    }

    public BusinessException(@NonNull ExceptionMessage exceptionMessage) {
        this.messageKey = exceptionMessage.getMessageKey();
        this.code = exceptionMessage.getCode();
        this.args = null;
    }
}
