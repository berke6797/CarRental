package com.bilgeadam.rentacarmonolitik.service;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveRentalRequestDto;
import com.bilgeadam.rentacarmonolitik.mapper.IRentalMapper;
import com.bilgeadam.rentacarmonolitik.repository.IRentalRepository;
import com.bilgeadam.rentacarmonolitik.repository.entity.Rental;
import com.bilgeadam.rentacarmonolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class RentalService extends ServiceManager<Rental,Long> {

    private final IRentalRepository iRentalRepository;

    public RentalService(IRentalRepository iRentalRepository) {
        super(iRentalRepository);
        this.iRentalRepository = iRentalRepository;
    }

    public Rental save (SaveRentalRequestDto dto){
        return save(IRentalMapper.INSTANCE.toRental(dto));
    }
}
