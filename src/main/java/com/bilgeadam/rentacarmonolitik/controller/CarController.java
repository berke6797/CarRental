package com.bilgeadam.rentacarmonolitik.controller;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveCarRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Car;
import com.bilgeadam.rentacarmonolitik.repository.entity.CarColorBrand;
import com.bilgeadam.rentacarmonolitik.repository.entity.CarCustomerRental;
import com.bilgeadam.rentacarmonolitik.repository.entity.CarDailyPrice;
import com.bilgeadam.rentacarmonolitik.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.bilgeadam.rentacarmonolitik.constants.EndPointList.*;

import java.util.List;

@RestController
@RequestMapping(CAR)
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping(SAVE)
    public ResponseEntity<Car> saveCar ( @RequestBody SaveCarRequestDto dto){
        return ResponseEntity.ok(carService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Car>> findAll(){
        return ResponseEntity.ok(carService.findAll());
    }
    @GetMapping(FIND_ALL_NAME_STARTING_WITH+"{/name}")
    public ResponseEntity<List<Car>> findAllByCarNameStartingWithIgnoreCase (@PathVariable String name){
        return ResponseEntity.ok(carService.findAllByCarNameStartingWithIgnoreCase(name));
    }
    @GetMapping(FIND_CAR_BY_BRAND_ID+"{/brandid}")
    public ResponseEntity<List<Car>> findAllByBrandId(@PathVariable long brandid){
        return ResponseEntity.ok(carService.findAllByBrandId(brandid));
    }

    @GetMapping(FIND_ALL_BY_COLOR_ID+"{/colorid}")
    public ResponseEntity<List<Car>> findAllByColorId(@PathVariable long colorid){
        return ResponseEntity.ok(carService.findAllByColorId(colorid));
    }

    @GetMapping(FIND_ALL_WITH_COLOR_AND_BRAND)
    public ResponseEntity<List<CarColorBrand>> showCarWithColorAndBrand(){
        return ResponseEntity.ok(carService.showCarWithColorAndBrand());
    }
    @GetMapping(FIND_ALL_CAR_LESS_THAN+"{/price}")
    public ResponseEntity<List<Car>> findAllByDailypriceLessThan(@PathVariable double price){
        return ResponseEntity.ok(carService.findAllByDailypriceLessThan(price));
    }

    @GetMapping(FIND_ALL_WITH_DAILY_PRICE)
    public ResponseEntity<List<CarDailyPrice>> showRentalCarListWithDailyPrice(){
        return ResponseEntity.ok(carService.showAllCarWithDailyPrice());
    }

    @GetMapping(FIND_ALL_WITH_CUSTOMER_RENTAL)
    public ResponseEntity<List<CarCustomerRental>> showRentalCarWithCustomer(){
        return ResponseEntity.ok(carService.showRentalCarWithCustomer());
    }

}
