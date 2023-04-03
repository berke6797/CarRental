package com.bilgeadam.rentacarmonolitik.controller;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveBrandRequestDto;
import com.bilgeadam.rentacarmonolitik.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Brand;
import com.bilgeadam.rentacarmonolitik.repository.entity.Customer;
import com.bilgeadam.rentacarmonolitik.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bilgeadam.rentacarmonolitik.constants.EndPointList.*;

import java.util.List;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody SaveCustomerRequestDto dto){
        customerService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findALl(){
        return ResponseEntity.ok(customerService.findAll());
    }

}
