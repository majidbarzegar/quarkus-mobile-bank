package com.bank.mobile.dto;

import java.time.LocalDateTime;

public record TransferInfoDto(String from,
                              String to,
                              Long amount,
                              String trackingNumber,
                              LocalDateTime time) {
}
