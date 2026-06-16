package com.bank.mobile.service;

import com.bank.mobile.client.corebanking.CoreBankingService;
import com.bank.mobile.client.corebanking.dto.CBCustomerDto;
import com.bank.mobile.dto.RegisterMobileBankRequest;
import com.bank.mobile.entity.MobileCustomer;
import com.bank.mobile.exception.BusinessException;
import com.bank.mobile.repository.MobileCustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

import static com.bank.mobile.exception.Message.CUSTOMER_IS_EXIST_IN_MOBILE_BANK;

@ApplicationScoped
public class MobileCustomerServiceImpl implements MobileCustomerService {

    @Inject
    CoreBankingService coreBankingService;

    @Inject
    MobileCustomerRepository mobileCustomerRepository;

    @Override
    @Transactional
    public MobileCustomer registerCustomer(RegisterMobileBankRequest request) {
        checkCustomerExistence(request.nationalCode());
        CBCustomerDto customerDto = coreBankingService.lookupCustomerByNationalCode(request.nationalCode());
        MobileCustomer mobileCustomer = new MobileCustomer();
        mobileCustomer.setNationalCode(customerDto.nationalCode());
        mobileCustomer.setFirstName(customerDto.firstName());
        mobileCustomer.setLastName(customerDto.lastName());
        mobileCustomer.setAccountNumber(customerDto.accountNumber());
        mobileCustomerRepository.persist(mobileCustomer);
        return mobileCustomer;
    }

    private void checkCustomerExistence(String nationalCode) {
        Optional<MobileCustomer> customer = mobileCustomerRepository.findByNationalCode(nationalCode);
        if (customer.isPresent()) {
            throw new BusinessException(CUSTOMER_IS_EXIST_IN_MOBILE_BANK);
        }
    }
}
