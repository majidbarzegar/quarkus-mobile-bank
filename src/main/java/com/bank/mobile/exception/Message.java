package com.bank.mobile.exception;

public enum Message implements ExceptionMessage {
    DEFAULT_EXCEPTION(1001),
    CUSTOMER_IS_EXIST_IN_MOBILE_BANK(1002)
    ;

    private final Integer code;

    Message(Integer code) {
        this.code = code;
    }

    public String getMessageKey() {
        return this.name();
    }

    public Integer getCode() {
        return code;
    }
}
