package com.bilgeadam.rentacarmonolitik.repository;

import com.bilgeadam.rentacarmonolitik.repository.entity.CarColorBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoinCarColorBrandRepository extends JpaRepository<CarColorBrand,Long> {

    @Query(nativeQuery = true, value = "select c.car_id,b.brand_name,c.car_name,c.modelyear,co.color_name from car as c\n" +
            "inner join brand as b on b.brand_id=c.brand_id\n" +
            "inner join color as co on co.color_id=c.color_id")
    List<CarColorBrand> showCarWithColorAndBrand();



}
