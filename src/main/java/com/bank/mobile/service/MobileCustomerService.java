package com.bank.mobile.service;

import com.bank.mobile.dto.RegisterMobileBankRequest;
import com.bank.mobile.entity.MobileCustomer;

public interface MobileCustomerService {
    MobileCustomer registerCustomer(RegisterMobileBankRequest request);
}
