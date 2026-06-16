package com.bank.mobile.client.corebanking;

import com.bank.mobile.client.corebanking.dto.CBCustomerDto;
import com.bank.mobile.client.corebanking.dto.CBTransferInfoDto;
import com.bank.mobile.client.corebanking.dto.CBTransferRequest;
import com.bank.mobile.client.corebanking.dto.CBTransferResponse;
import com.bank.mobile.client.corebanking.exception.CoreBankingMessage;
import com.bank.mobile.exception.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class CoreBankingService {

    @Inject
    @RestClient
    CoreBankingClient client;


    public CBCustomerDto saveCustomer(CBCustomerDto dto) {
        return client.saveCustomer(dto).getResponse();
    }

    public void deleteCustomer(Long id) {
        client.deleteCustomer(id);
    }

    public CBCustomerDto findCustomerById(Long id) {
        return client.findCustomerById(id).getResponse();
    }

    public CBCustomerDto lookupCustomerByAccount(String accountNumber) {
        return client.lookupCustomerByAccount(accountNumber).getResponse();
    }

    public CBCustomerDto lookupCustomerByNationalCode(String nationalCode) {
        CBCustomerDto customerDto = client.lookupCustomerByNationalCode(nationalCode).getResponse();
        if (customerDto == null) {
            throw new BusinessException(CoreBankingMessage.CUSTOMER_NOT_FOUND);
        }
        return customerDto;
    }

    public CBTransferResponse transfer(CBTransferRequest request, String currentUserNationalCode) {
        return client.transfer(request, currentUserNationalCode).getResponse();
    }

    public List<CBTransferInfoDto> transferHistory(String currentUserNationalCode) {
        return client.transferHistory(currentUserNationalCode).getResponse();
    }

}
