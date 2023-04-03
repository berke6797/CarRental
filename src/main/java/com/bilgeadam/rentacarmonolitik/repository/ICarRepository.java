package com.bilgeadam.rentacarmonolitik.repository;

import com.bilgeadam.rentacarmonolitik.repository.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car,Long> {
    List<Car> findAllByCarNameStartingWithIgnoreCase(String name);
    List<Car> findAllByBrandId(long brandid);
    List<Car> findAllByColorId(long colorid);
    List<Car> findAllByDailypriceLessThan(double price);


}
