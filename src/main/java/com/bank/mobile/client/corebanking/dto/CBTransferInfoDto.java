package com.bank.mobile.client.corebanking.dto;

import java.time.LocalDateTime;

public record CBTransferInfoDto(String from,
                                String to,
                                Long amount,
                                String trackingNumber,
                                LocalDateTime time) {
}
