package com.bilgeadam.rentacarmonolitik.service;


import com.bilgeadam.rentacarmonolitik.repository.IJoinCarCustomerRentalRepository;
import com.bilgeadam.rentacarmonolitik.repository.entity.CarCustomerRental;
import com.bilgeadam.rentacarmonolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinCarCustomerRentalService extends ServiceManager<CarCustomerRental,Long> {

    private final IJoinCarCustomerRentalRepository iJoinCarCustomerRentalRepository;

    public JoinCarCustomerRentalService(IJoinCarCustomerRentalRepository iJoinCarCustomerRentalRepository) {
        super(iJoinCarCustomerRentalRepository);
        this.iJoinCarCustomerRentalRepository = iJoinCarCustomerRentalRepository;
    }

    public List<CarCustomerRental> showRentalCarWithCustomer(){
        return iJoinCarCustomerRentalRepository.showRentalCarWithCustomer();
    }
}
