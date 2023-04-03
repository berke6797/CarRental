package com.bilgeadam.rentacarmonolitik.mapper;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveBrandRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IBrandMapper {
    IBrandMapper INSTANCE= Mappers.getMapper(IBrandMapper.class);
    Brand toBrand(final SaveBrandRequestDto dto);
}
