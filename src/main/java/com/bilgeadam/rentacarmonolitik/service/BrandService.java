package com.bilgeadam.rentacarmonolitik.service;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveBrandRequestDto;
import com.bilgeadam.rentacarmonolitik.exception.ErrorType;
import com.bilgeadam.rentacarmonolitik.exception.RentACarException;
import com.bilgeadam.rentacarmonolitik.mapper.IBrandMapper;
import com.bilgeadam.rentacarmonolitik.repository.IBrandRepository;
import com.bilgeadam.rentacarmonolitik.repository.entity.Brand;
import com.bilgeadam.rentacarmonolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService extends ServiceManager<Brand,Long> {
    private final IBrandRepository iBrandRepository;

    public BrandService(IBrandRepository iBrandRepository) {
        super(iBrandRepository);
        this.iBrandRepository = iBrandRepository;
    }
    public void save (SaveBrandRequestDto dto){
        Optional<Brand> brand= iBrandRepository.findByBrandNameIgnoreCase(dto.getBrandName());
        if (brand.isPresent()) {
            throw new RuntimeException("Bu marka araç bulunmaktadır !");
        }
        save(IBrandMapper.INSTANCE.toBrand(dto));
    }
    public List<Brand> findAll() {
        List<Brand> brands = iBrandRepository.findAll();
        if (brands.isEmpty())
            throw new RentACarException(ErrorType.BRAND_NOT_FOUND);
        return brands;
    }


}
