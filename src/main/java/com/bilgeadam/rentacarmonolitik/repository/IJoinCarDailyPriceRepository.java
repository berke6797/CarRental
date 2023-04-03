package com.bilgeadam.rentacarmonolitik.repository;

import com.bilgeadam.rentacarmonolitik.repository.entity.CarDailyPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoinCarDailyPriceRepository extends JpaRepository<CarDailyPrice,Long> {
    @Query(nativeQuery = true, value="select r.rental_id,b.brand_name,c.car_name,co.color_name,c.modelyear,c.dailyprice from car as c\n" +
            "inner join rental as r on r.car_id= c.car_id\n" +
            "inner join brand as b on b.brand_id=c.brand_id\n" +
            "inner join color as co on co.color_id=c.color_id")
    List<CarDailyPrice> showAllCarWithDailyPrice();


}
