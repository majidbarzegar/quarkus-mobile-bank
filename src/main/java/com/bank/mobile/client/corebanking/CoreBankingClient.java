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
    CBResponseDto<CBCustomerDto> saveCustomer(CBCustomerDto dto);

    @DELETE
    @Path("/customers/{id}")
    CBResponseDto<String> deleteCustomer(@PathParam("id") Long id);

    @GET
    @Path("/customers/{id}")
    CBResponseDto<CBCustomerDto> findCustomerById(@PathParam("id") Long id);

    @GET
    @Path("/customers/by-account/{accountNumber}")
    CBResponseDto<CBCustomerDto> lookupCustomerByAccount(@PathParam("accountNumber") String accountNumber);

    @GET
    @Path("/customers/by-national-code/{nationalCode}")
    CBResponseDto<CBCustomerDto> lookupCustomerByNationalCode(@PathParam("nationalCode") String nationalCode);

    @POST
    @Path("/transfers")
    CBResponseDto<CBTransferResponse> transfer(CBTransferRequest request, @HeaderParam("X-National-Code") String currentUserNationalCode);

    @GET
    @Path("/transfers/history")
    CBResponseDto<List<CBTransferInfoDto>> transferHistory(@HeaderParam("X-National-Code") String currentUserNationalCode);

}
