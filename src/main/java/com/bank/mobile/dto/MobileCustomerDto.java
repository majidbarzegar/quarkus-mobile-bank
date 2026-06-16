package com.bank.mobile.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MobileCustomerDto {
    private Long id;
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String accountNumber;
}
