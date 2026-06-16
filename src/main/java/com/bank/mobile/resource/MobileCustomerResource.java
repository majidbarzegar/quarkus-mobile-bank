package com.bank.mobile.resource;

import com.bank.mobile.dto.MobileCustomerDto;
import com.bank.mobile.dto.RegisterMobileBankRequest;
import com.bank.mobile.dto.ResponseDto;
import com.bank.mobile.entity.MobileCustomer;
import com.bank.mobile.mapper.MobileCustomerMapper;
import com.bank.mobile.service.MobileCustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/bank/mobile/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileCustomerResource {

    @Inject
    MobileCustomerService mobileCustomerService;
    @Inject
    MobileCustomerMapper mobileCustomerMapper;

    @POST
    public ResponseDto<MobileCustomerDto> save(RegisterMobileBankRequest request) {
        MobileCustomer mobileCustomer = mobileCustomerService.registerCustomer(request);
        return new ResponseDto<>(
                mobileCustomerMapper.toDto(mobileCustomer)
        );
    }
}
