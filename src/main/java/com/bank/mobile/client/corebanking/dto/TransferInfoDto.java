package com.bank.mobile.client.corebanking.dto;

import java.time.LocalDateTime;

public record TransferInfoDto(String from,
                              String to,
                              Long amount,
                              String trackingNumber,
                              LocalDateTime time) {
}
