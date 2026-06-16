package com.bank.mobile.service;

import com.bank.mobile.cache.NameLookupKeyGenerator;
import com.bank.mobile.client.corebanking.CoreBankingService;
import com.bank.mobile.client.corebanking.dto.CBTransferInfoDto;

import com.bank.mobile.client.corebanking.dto.CBTransferRequest;
import com.bank.mobile.client.corebanking.dto.CBTransferResponse;
import com.bank.mobile.dto.TransferRequest;
import com.bank.mobile.dto.TransferResponse;
import com.bank.mobile.exception.Message;
import com.bank.mobile.util.MessageUtil;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TransferServiceImpl implements TransferService{

    @Inject
    CoreBankingService coreBankingService;
    @Inject
    OtpService otpService;


    @Override
    @CacheResult(cacheName = "name-lookup-cache", keyGenerator = NameLookupKeyGenerator.class)
    public String nameLookup(String accountNumber) {
        return coreBankingService.lookupCustomerByAccount(accountNumber).getFullName();
    }

    @Override
    public void sendTransferOtp(String currentUserNationalCode) {
        otpService.sendOtp(currentUserNationalCode);
    }

    @Override
    public TransferResponse transfer(TransferRequest request, String currentUserNationalCode) {
        otpService.checkOtp(currentUserNationalCode, request.otp());
        CBTransferResponse transferResponse = coreBankingService.transfer(
                new CBTransferRequest(
                        request.destinationAccountNumber(),
                        request.amount()
                ),
                currentUserNationalCode);
        return new TransferResponse(
                transferResponse.trackingNumber(),
                MessageUtil.getMessage(
                        Message.SUCCESSFUL_TRANSFER.getMessageKey(),
                        nameLookup(request.destinationAccountNumber())
                )
        );
    }

    @Override
    public List<CBTransferInfoDto> history(String currentUserNationalCode) {
        return coreBankingService.transferHistory(currentUserNationalCode);
    }

}
