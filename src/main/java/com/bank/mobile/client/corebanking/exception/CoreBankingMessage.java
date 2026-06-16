package com.bank.mobile.client.corebanking.exception;

import com.bank.mobile.exception.ExceptionMessage;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum CoreBankingMessage implements ExceptionMessage {
    CORE_BANKING_DEFAULT_EXCEPTION(1_1001, 1001),
    CUSTOMER_NOT_FOUND(1_1002, 1002),
    ACCOUNT_NUMBER_NOT_FOUND(1_1003, 1003),
    EMPTY_HISTORY(1_1004, 1004),
    INSUFFICIENT_BALANCE(1_1005, 1005),
    INVALID_TRANSFER_AMOUNT(1_1006, 1006),
    ;

    private final Integer code;
    private final Integer coreBankingCode;

    private static final Map<Integer, CoreBankingMessage> CB_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(CoreBankingMessage::getCoreBankingCode, Function.identity()));

    CoreBankingMessage(Integer code, Integer coreBankingCode) {
        this.code = code;
        this.coreBankingCode = coreBankingCode;
    }

    public static CoreBankingMessage getByCoreBankingCode(Integer cbCode) {
        return CB_MAP.get(cbCode);
    }

    @Override
    public String getMessageKey() {
        return name();
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public Integer getCoreBankingCode() {
        return coreBankingCode;
    }
}
