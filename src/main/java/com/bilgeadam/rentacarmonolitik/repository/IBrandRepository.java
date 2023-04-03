package com.bilgeadam.rentacarmonolitik.repository;

import com.bilgeadam.rentacarmonolitik.repository.entity.Brand;
import com.bilgeadam.rentacarmonolitik.repository.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBrandRepository extends JpaRepository<Brand,Long> {
    Optional<Brand> findByBrandNameIgnoreCase(String name);

}
