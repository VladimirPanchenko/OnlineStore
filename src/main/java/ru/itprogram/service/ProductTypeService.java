package ru.itprogram.service;

import ru.itprogram.entity.dao.ProductType;
import ru.itprogram.entity.dto.ProductTypeDto;
import ru.itprogram.repository.ProductTypeRepository;
import ru.itprogram.service.converter.producttype.ProductTypeDtoToProductType;
import ru.itprogram.service.converter.producttype.ProductTypeToProductTypeDto;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeService implements Service<ProductTypeDto> {
    @Override
    public List<ProductTypeDto> getAll() {
        List<ProductType> productTypes = new ProductTypeRepository().getAllEntity();
        List<ProductTypeDto> productTypeDtoList = new ArrayList<>();
        for (ProductType productType : productTypes) {
            productTypeDtoList.add(new ProductTypeToProductTypeDto().conversion(productType));
        }
        return productTypeDtoList;
    }

    @Override
    public void add(ProductTypeDto productTypeDto) {
        new ProductTypeRepository().saveEntity(
                new ProductTypeDtoToProductType().conversion(productTypeDto));
    }
}
