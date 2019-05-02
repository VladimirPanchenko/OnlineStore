package ru.itprogram.service.converter.brand;

import ru.itprogram.entity.dao.Brand;
import ru.itprogram.entity.dto.BrandDto;
import ru.itprogram.service.converter.Converter;

public class BrandToBrandDto implements Converter<BrandDto, Brand> {
    @Override
    public BrandDto conversion(Brand brand) {
        BrandDto brandDto = new BrandDto();
        brandDto.setName(brand.getName());
        return brandDto;
    }
}
