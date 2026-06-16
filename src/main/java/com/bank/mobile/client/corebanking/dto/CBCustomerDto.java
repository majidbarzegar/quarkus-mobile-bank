package com.bank.mobile.client.corebanking.dto;


public record CBCustomerDto(Long id,
                            String nationalCode,
                            String firstName,
                            String lastName,
                            String accountNumber,
                            Long balance) {

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
