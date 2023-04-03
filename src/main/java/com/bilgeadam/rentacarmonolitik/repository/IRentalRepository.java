package com.bilgeadam.rentacarmonolitik.repository;

import com.bilgeadam.rentacarmonolitik.repository.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalRepository extends JpaRepository<Rental,Long> {
}
