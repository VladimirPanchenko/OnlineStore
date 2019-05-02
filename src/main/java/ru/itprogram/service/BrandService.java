package ru.itprogram.service;

import ru.itprogram.entity.dao.Brand;
import ru.itprogram.entity.dto.BrandDto;
import ru.itprogram.repository.BrandRepository;
import ru.itprogram.service.converter.brand.BrandDtoToBrand;
import ru.itprogram.service.converter.brand.BrandToBrandDto;

import java.util.ArrayList;
import java.util.List;

public class BrandService implements Service<BrandDto> {
    @Override
    public List<BrandDto> getAll() {
        List<Brand> brands = new BrandRepository().getAllEntity();
        List<BrandDto> brandDtoList = new ArrayList<>();
        for (Brand brand : brands) {
            brandDtoList.add(new BrandToBrandDto().conversion(brand));
        }
        return brandDtoList;
    }

    @Override
    public void add(BrandDto brandDto) {
        new BrandRepository().saveEntity(new BrandDtoToBrand().conversion(brandDto));
    }
}
