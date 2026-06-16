package com.bank.mobile.resource;

import com.bank.mobile.client.corebanking.dto.CBTransferInfoDto;
import com.bank.mobile.dto.ResponseDto;
import com.bank.mobile.dto.TransferRequest;
import com.bank.mobile.dto.TransferResponse;
import com.bank.mobile.service.TransferService;
import com.bank.mobile.util.MessageUtil;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.bank.mobile.exception.Message.SUCCESSFUL_TRANSFER_SENDING_OTP;

@Path("/api/bank/mobile/transfers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransferResource {

    @Inject
    TransferService transferService;

    @GET
    @Path("/name-lookup/{account-number}")
    public ResponseDto<String> nameLookup(@PathParam("account-number") String accountNumber) {
        return new ResponseDto<>(
                transferService.nameLookup(accountNumber)
        );
    }

    @POST
    @Path("/otp")
    public ResponseDto<String> sendTransferOtp(@HeaderParam("X-National-Code") String currentUserNationalCode) {
        transferService.sendTransferOtp(currentUserNationalCode);
        return new ResponseDto<>(MessageUtil.getMessage(SUCCESSFUL_TRANSFER_SENDING_OTP.getMessageKey()));
    }

    @POST
    public ResponseDto<TransferResponse> transfer(TransferRequest request,
                                                  @HeaderParam("X-National-Code") String currentUserNationalCode) {
        return new ResponseDto<>(
                transferService.transfer(request, currentUserNationalCode)
        );
    }

    @GET
    @Path("/history")
    public ResponseDto<List<CBTransferInfoDto>> history(@HeaderParam("X-National-Code") String currentUserNationalCode) {
        return new ResponseDto<>(
                transferService.history(currentUserNationalCode)
        );
    }
}
