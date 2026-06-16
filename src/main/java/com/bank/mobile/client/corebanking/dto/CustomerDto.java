package com.bank.mobile.client.corebanking.dto;


public record CustomerDto(Long id,
                         String nationalCode,
                         String firstName,
                         String lastName,
                         String accountNumber,
                         Long balance) {
}
