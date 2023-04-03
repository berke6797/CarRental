package com.bilgeadam.rentacarmonolitik.service;

import com.bilgeadam.rentacarmonolitik.repository.IJoinCarColorBrandRepository;
import com.bilgeadam.rentacarmonolitik.repository.entity.CarColorBrand;
import com.bilgeadam.rentacarmonolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinCarColorBrandService extends ServiceManager<CarColorBrand,Long> {

    private final IJoinCarColorBrandRepository iJoinCarColorBrandRepository;

    public JoinCarColorBrandService(IJoinCarColorBrandRepository iJoinCarColorBrandRepository) {
        super(iJoinCarColorBrandRepository);
        this.iJoinCarColorBrandRepository = iJoinCarColorBrandRepository;
    }

    public List<CarColorBrand> showCarWithColorAndBrand(){
        return iJoinCarColorBrandRepository.showCarWithColorAndBrand();
    }


}
