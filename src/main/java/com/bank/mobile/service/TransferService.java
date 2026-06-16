package com.bank.mobile.service;

import com.bank.mobile.client.corebanking.dto.CBTransferInfoDto;
import com.bank.mobile.dto.TransferRequest;
import com.bank.mobile.dto.TransferResponse;

import java.util.List;

public interface TransferService {
    String nameLookup(String accountNumber);

    TransferResponse transfer(TransferRequest request, String currentUserNationalCode);

    List<CBTransferInfoDto> history(String currentUserNationalCode);

    void sendTransferOtp(String currentUserNationalCode);
}
