package com.bilgeadam.rentacarmonolitik.controller;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveRentalRequestDto;
import com.bilgeadam.rentacarmonolitik.mapper.IRentalMapper;
import com.bilgeadam.rentacarmonolitik.repository.entity.Rental;
import com.bilgeadam.rentacarmonolitik.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.bilgeadam.rentacarmonolitik.constants.EndPointList.*;

import java.util.List;

@RestController
@RequestMapping(RENTAL)
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;
    @PostMapping(SAVE)
    public ResponseEntity<Rental> save (@RequestBody SaveRentalRequestDto dto){
       return ResponseEntity.ok(rentalService.save(dto)) ;
    }
   @GetMapping(FIND_ALL)
   public ResponseEntity<List<Rental>> findAll(){
        return ResponseEntity.ok(rentalService.findAll());
   }
}
