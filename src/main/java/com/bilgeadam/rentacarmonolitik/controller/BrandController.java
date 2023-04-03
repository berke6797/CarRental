package com.bilgeadam.rentacarmonolitik.controller;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveBrandRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Brand;
import com.bilgeadam.rentacarmonolitik.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.bilgeadam.rentacarmonolitik.constants.EndPointList.*;
import java.util.List;

@RestController
@RequestMapping(BRAND)
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody SaveBrandRequestDto dto){
    brandService.save(dto);
    return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Brand>> findALl(){
        return ResponseEntity.ok(brandService.findAll());
    }
}
