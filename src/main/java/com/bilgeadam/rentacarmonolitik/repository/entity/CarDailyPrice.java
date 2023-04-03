package com.bilgeadam.rentacarmonolitik.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_car_dailyprice")
public class CarDailyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rentalId;
    String brandName;
    String carName;
    Long modelyear;
    String colorName;
    double dailyprice;
}
