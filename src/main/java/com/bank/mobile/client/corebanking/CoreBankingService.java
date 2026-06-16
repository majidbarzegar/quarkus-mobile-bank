package com.bank.mobile.client.corebanking;

import com.bank.mobile.client.corebanking.dto.CustomerDto;
import com.bank.mobile.client.corebanking.dto.TransferInfoDto;
import com.bank.mobile.client.corebanking.dto.TransferRequest;
import com.bank.mobile.client.corebanking.dto.TransferResponse;
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


    public CustomerDto saveCustomer(CustomerDto dto) {
        return client.saveCustomer(dto).getResponse();
    }

    public void deleteCustomer(Long id) {
        client.deleteCustomer(id);
    }

    public CustomerDto findCustomerById(Long id) {
        return client.findCustomerById(id).getResponse();
    }

    public CustomerDto lookupCustomerByAccount(String accountNumber) {
        return client.lookupCustomerByAccount(accountNumber).getResponse();
    }

    public CustomerDto lookupCustomerByNationalCode(String nationalCode) {
        CustomerDto customerDto = client.lookupCustomerByNationalCode(nationalCode).getResponse();
        if (customerDto == null) {
            throw new BusinessException(CoreBankingMessage.CUSTOMER_NOT_FOUND);
        }
        return customerDto;
    }

    public TransferResponse transfer(TransferRequest request, String currentUserNationalCode) {
        return client.transfer(request, currentUserNationalCode).getResponse();
    }

    public List<TransferInfoDto> transferHistory(String currentUserNationalCode) {
        return client.transferHistory(currentUserNationalCode).getResponse();
    }

}
