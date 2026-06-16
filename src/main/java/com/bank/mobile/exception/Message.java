package com.bank.mobile.exception;

public enum Message implements ExceptionMessage {
    DEFAULT_EXCEPTION(1001),
    CUSTOMER_IS_EXIST_IN_MOBILE_BANK(1002),
    SUCCESSFUL_TRANSFER(1003),
    SUCCESSFUL_TRANSFER_SENDING_OTP(1004),
    OTP_EXPIRED_OR_NOT_FOUND(1005),
    INVALID_OTP(1006),
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
