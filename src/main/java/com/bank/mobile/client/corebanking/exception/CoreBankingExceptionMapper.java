package com.bank.mobile.client.corebanking.exception;


import com.bank.mobile.client.corebanking.dto.CBResponseDto;
import com.bank.mobile.exception.BusinessException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class CoreBankingExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public RuntimeException toThrowable(Response response) {
        if (response.getStatus() == 406) {
            response.bufferEntity();
            CBResponseDto<?> errorDto = response.readEntity(CBResponseDto.class);
            if (errorDto == null || errorDto.getCode() == null) {
                return new BusinessException(CoreBankingMessage.CORE_BANKING_DEFAULT_EXCEPTION);
            }
            CoreBankingMessage cbException = CoreBankingMessage.getByCoreBankingCode(errorDto.getCode());
            if (cbException == null) {
                return new BusinessException(CoreBankingMessage.CORE_BANKING_DEFAULT_EXCEPTION);
            }
            throw new BusinessException(cbException);
        }
        return new BusinessException(CoreBankingMessage.CORE_BANKING_DEFAULT_EXCEPTION);
    }
}