package com.bilgeadam.rentacarmonolitik.service;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveCarRequestDto;
import com.bilgeadam.rentacarmonolitik.exception.ErrorType;
import com.bilgeadam.rentacarmonolitik.exception.RentACarException;
import com.bilgeadam.rentacarmonolitik.mapper.ICarMapper;
import com.bilgeadam.rentacarmonolitik.repository.ICarRepository;
import com.bilgeadam.rentacarmonolitik.repository.entity.*;
import com.bilgeadam.rentacarmonolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends ServiceManager<Car, Long> {
    private final ICarRepository iCarRepository;
    private final JoinCarColorBrandService joinCarColorBrandService;
    private final JoinCarDailyPriceService joinCarDailyPriceService;
    private final JoinCarCustomerRentalService joinCarCustomerRentalService;


    public CarService(ICarRepository iCarRepository, JoinCarColorBrandService joinCarColorBrandService, JoinCarDailyPriceService joinCarDailyPriceService, JoinCarCustomerRentalService joinCarCustomerRentalService) {
        super(iCarRepository);
        this.iCarRepository = iCarRepository;
        this.joinCarColorBrandService = joinCarColorBrandService;
        this.joinCarDailyPriceService = joinCarDailyPriceService;
        this.joinCarCustomerRentalService = joinCarCustomerRentalService;
    }

    public Car save(SaveCarRequestDto dto) {
        Car car = save(ICarMapper.INSTANCE.toCar(dto));
        return car;
    }
    public List<Car> findAll() {
        List<Car> carList = iCarRepository.findAll();
        if (carList.isEmpty())
            throw new RentACarException(ErrorType.CAR_NOT_FOUND);
        return carList;
    }

    public List<Car> findAllByCarNameStartingWithIgnoreCase(String name) {
        List<Car> carList = iCarRepository.findAllByCarNameStartingWithIgnoreCase(name);
        if (carList.isEmpty()) {
            throw new RentACarException(ErrorType.CAR_NOT_FOUND);
        }
        return carList;
    }

    public List<Car> findAllByBrandId(long brandid) {
        List<Car> carList = iCarRepository.findAllByBrandId(brandid);
        if (carList.isEmpty()) {
            throw new RentACarException(ErrorType.CAR_NOT_FOUND);
        }
        return carList;
    }

    public List<Car> findAllByColorId(long colorid) {
        List<Car> carList = iCarRepository.findAllByColorId(colorid);
        if (carList.isEmpty()) {
            throw new RuntimeException("Bu renkte araç bulunmamaktadır.");
        }
        return carList;
    }

    public List<CarColorBrand> showCarWithColorAndBrand() {
        return joinCarColorBrandService.showCarWithColorAndBrand();
    }

    public List<Car> findAllByDailypriceLessThan(double price){
        return iCarRepository.findAllByDailypriceLessThan(price);
    }

    public List<CarDailyPrice> showAllCarWithDailyPrice(){
        List<CarDailyPrice> rentalCarList= joinCarDailyPriceService.showAllCarWithDailyPrice();
        if (rentalCarList.isEmpty()){
            throw new RuntimeException("Kiralık araba listesi boş");
        }
        return rentalCarList;
    }
    public List<CarCustomerRental> showRentalCarWithCustomer(){
        return joinCarCustomerRentalService.showRentalCarWithCustomer();
    }

}
