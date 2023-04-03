package com.bilgeadam.rentacarmonolitik.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCarRequestDto {
    String carName;
    Long modelyear;
    double dailyprice;
    String description;
    Long brandId;
    Long colorId;
}
