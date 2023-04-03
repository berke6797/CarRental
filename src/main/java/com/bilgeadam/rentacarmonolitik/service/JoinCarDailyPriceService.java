package com.bilgeadam.rentacarmonolitik.service;

import com.bilgeadam.rentacarmonolitik.repository.IJoinCarDailyPriceRepository;
import com.bilgeadam.rentacarmonolitik.repository.entity.CarDailyPrice;
import com.bilgeadam.rentacarmonolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinCarDailyPriceService extends ServiceManager<CarDailyPrice,Long> {

    private final IJoinCarDailyPriceRepository iJoinCarDailyPriceRepository;

    public JoinCarDailyPriceService(IJoinCarDailyPriceRepository iJoinCarDailyPriceRepository) {
        super(iJoinCarDailyPriceRepository);
        this.iJoinCarDailyPriceRepository = iJoinCarDailyPriceRepository;
    }

    public List<CarDailyPrice> showAllCarWithDailyPrice(){
        return iJoinCarDailyPriceRepository.showAllCarWithDailyPrice();
    }


}
