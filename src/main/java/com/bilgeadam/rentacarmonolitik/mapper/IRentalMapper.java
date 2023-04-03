package com.bilgeadam.rentacarmonolitik.mapper;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveRentalRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRentalMapper {
    IRentalMapper INSTANCE = Mappers.getMapper(IRentalMapper.class);
    Rental toRental(final SaveRentalRequestDto dtoRental);
}
