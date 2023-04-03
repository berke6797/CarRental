package com.bilgeadam.rentacarmonolitik.service;

import com.bilgeadam.rentacarmonolitik.dto.request.SaveBrandRequestDto;
import com.bilgeadam.rentacarmonolitik.dto.request.SaveColorRequestDto;
import com.bilgeadam.rentacarmonolitik.exception.ErrorType;
import com.bilgeadam.rentacarmonolitik.exception.RentACarException;
import com.bilgeadam.rentacarmonolitik.mapper.IBrandMapper;
import com.bilgeadam.rentacarmonolitik.mapper.IColorMapper;
import com.bilgeadam.rentacarmonolitik.repository.IColorRepository;
import com.bilgeadam.rentacarmonolitik.repository.entity.Brand;
import com.bilgeadam.rentacarmonolitik.repository.entity.Color;
import com.bilgeadam.rentacarmonolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService extends ServiceManager<Color,Long> {
    private final IColorRepository iColorRepository;

    public ColorService(IColorRepository iColorRepository) {
        super(iColorRepository);
        this.iColorRepository = iColorRepository;
    }

    public void save (SaveColorRequestDto dto){
        Optional<Color> color= iColorRepository.findOptionalByColorNameIgnoreCase(dto.getColorName());
        if (color.isPresent()) {
            throw new RuntimeException("Bu renk araç bulunmaktadır !");
        }
        save(IColorMapper.INSTANCE.toColor(dto));
    }
    public List<Color> findAll() {
        List<Color> colorList = iColorRepository.findAll();
        if (colorList.isEmpty())
            throw new RentACarException(ErrorType.COLOR_NOT_FOUND);
        return colorList;
    }

}
