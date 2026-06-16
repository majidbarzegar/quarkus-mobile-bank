package com.bank.mobile.client.corebanking;

import com.bank.mobile.client.corebanking.dto.*;
import com.bank.mobile.client.corebanking.exception.CoreBankingExceptionMapper;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/bank/core")
@RegisterRestClient(configKey = "cb-api")
@RegisterProvider(CoreBankingExceptionMapper.class)
public interface CoreBankingClient {

    @POST
    @Path("/customers")
    CBResponseDto<CustomerDto> saveCustomer(CustomerDto dto);

    @DELETE
    @Path("/customers/{id}")
    CBResponseDto<String> deleteCustomer(@PathParam("id") Long id);

    @GET
    @Path("/customers/{id}")
    CBResponseDto<CustomerDto> findCustomerById(@PathParam("id") Long id);

    @GET
    @Path("/customers/by-account/{accountNumber}")
    CBResponseDto<CustomerDto> lookupCustomerByAccount(@PathParam("accountNumber") String accountNumber);

    @GET
    @Path("/customers/by-national-code/{nationalCode}")
    CBResponseDto<CustomerDto> lookupCustomerByNationalCode(@PathParam("nationalCode") String nationalCode);

    @POST
    @Path("/transfers")
    CBResponseDto<TransferResponse> transfer(TransferRequest request, @HeaderParam("X-National-Code") String currentUserNationalCode);

    @POST
    @Path("/transfers/history")
    CBResponseDto<List<TransferInfoDto>> transferHistory(@HeaderParam("X-National-Code") String currentUserNationalCode);

}
