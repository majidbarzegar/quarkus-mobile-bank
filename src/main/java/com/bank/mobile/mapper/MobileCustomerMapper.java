package com.bank.mobile.mapper;

import com.bank.mobile.dto.MobileCustomerDto;
import com.bank.mobile.entity.MobileCustomer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MobileCustomerMapper {
    MobileCustomer toEntity(MobileCustomerDto dto);

    List<MobileCustomer> toEntity(List<MobileCustomerDto> dtos);

    MobileCustomerDto toDto(MobileCustomer MobileCustomer);

    List<MobileCustomerDto> toDto(List<MobileCustomer> MobileCustomers);
}
