package com.bank.mobile.client.corebanking.dto;

public record CBTransferRequest(String destinationAccountNumber,
                                Long amount) {
}
