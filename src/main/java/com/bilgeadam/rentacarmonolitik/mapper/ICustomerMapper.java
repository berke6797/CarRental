package com.bilgeadam.rentacarmonolitik.mapper;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {
    ICustomerMapper INSTANCE= Mappers.getMapper(ICustomerMapper.class);
    Customer toCustomer(final SaveCustomerRequestDto dto);
}
