package com.bilgeadam.rentacarmonolitik.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveRentalRequestDto {
    Long rentDate;
    Long carId;
    Long customerId;
}
