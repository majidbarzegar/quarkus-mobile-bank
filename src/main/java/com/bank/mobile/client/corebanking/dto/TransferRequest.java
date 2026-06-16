package com.bank.mobile.client.corebanking.dto;

public record TransferRequest(String destinationAccountNumber,
                              Long amount) {
}
