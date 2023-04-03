package com.bilgeadam.rentacarmonolitik.mapper;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveColorRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Color;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IColorMapper {
    IColorMapper INSTANCE= Mappers.getMapper(IColorMapper.class);
    Color toColor(final SaveColorRequestDto dto);

}
