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
@Table(name = "tbl_car_color_brand")
public class CarColorBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long carId;
    String carName;
    String brandName;
    String colorName;

}
