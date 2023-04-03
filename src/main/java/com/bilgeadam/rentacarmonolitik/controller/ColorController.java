package com.bilgeadam.rentacarmonolitik.controller;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveBrandRequestDto;
import com.bilgeadam.rentacarmonolitik.dto.request.SaveColorRequestDto;
import com.bilgeadam.rentacarmonolitik.repository.entity.Brand;
import com.bilgeadam.rentacarmonolitik.repository.entity.Color;
import com.bilgeadam.rentacarmonolitik.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bilgeadam.rentacarmonolitik.constants.EndPointList.*;

import java.util.List;

@RestController
@RequestMapping(COLOR)
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;


    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody SaveColorRequestDto dto){
        colorService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Color>> findALl(){
        return ResponseEntity.ok(colorService.findAll());
    }

}
