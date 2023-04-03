package com.bilgeadam.rentacarmonolitik.service;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.rentacarmonolitik.exception.ErrorType;
import com.bilgeadam.rentacarmonolitik.exception.RentACarException;
import com.bilgeadam.rentacarmonolitik.mapper.ICustomerMapper;
import com.bilgeadam.rentacarmonolitik.repository.ICustomerRepository;
import com.bilgeadam.rentacarmonolitik.repository.entity.Brand;
import com.bilgeadam.rentacarmonolitik.repository.entity.Color;
import com.bilgeadam.rentacarmonolitik.repository.entity.Customer;
import com.bilgeadam.rentacarmonolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {
    private final ICustomerRepository iCustomerRepository;

    public CustomerService(ICustomerRepository iCustomerRepository) {
        super(iCustomerRepository);
        this.iCustomerRepository = iCustomerRepository;
    }

    public void save(SaveCustomerRequestDto dto){
        Optional<Customer> customer= iCustomerRepository.findByCustomerNameAndCompanyNameIgnoreCase(dto.getCompanyName(), dto.getCustomerName());
        if(customer.isPresent()){
            throw new RuntimeException("Böyle bir müşteri bulunmaktadır");
        }
        save(ICustomerMapper.INSTANCE.toCustomer(dto));

    }

    public List<Customer> findAll() {
        List<Customer> customerList = iCustomerRepository.findAll();
        if (customerList.isEmpty())
            throw new RentACarException(ErrorType.CUSTOMER_NOT_FOUND);
        return customerList;
    }

}
