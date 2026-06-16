package com.bank.mobile.dto;

public record TransferRequest(String destinationAccountNumber,
                              Long amount,
                              String otp) {
}
