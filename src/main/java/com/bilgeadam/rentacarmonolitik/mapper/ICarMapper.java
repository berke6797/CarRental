package com.bilgeadam.rentacarmonolitik.mapper;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveCarRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ICarMapper {

    ICarMapper INSTANCE = Mappers.getMapper(ICarMapper.class);
    Car toCar(final SaveCarRequestDto carRequestDto);
}
