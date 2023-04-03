package com.bilgeadam.rentacarmonolitik.repository;

import com.bilgeadam.rentacarmonolitik.repository.entity.CarCustomerRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoinCarCustomerRentalRepository extends JpaRepository<CarCustomerRental,Long> {
    @Query(nativeQuery = true,value =
            "select r.rental_id,r.rent_date,b.brand_name,c.car_name,c.modelyear,c.dailyprice,cu.company_name,cu.customer_name from car as c\n" +
            "inner join rental as r on r.car_id= c.car_id\n" +
            "inner join brand as b on b.brand_id=c.brand_id\n" +
            "inner join customer as cu on r.customer_id=cu.customer_id")
    List<CarCustomerRental> showRentalCarWithCustomer();
}
