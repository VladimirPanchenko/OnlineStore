package ru.itprogram.service.converter.producttype;

import ru.itprogram.entity.dao.ProductType;
import ru.itprogram.entity.dto.ProductTypeDto;
import ru.itprogram.service.converter.Converter;

public class ProductTypeToProductTypeDto implements Converter<ProductTypeDto, ProductType> {
    @Override
    public ProductTypeDto conversion(ProductType productType) {
        ProductTypeDto productTypeDto = new ProductTypeDto();
        productTypeDto.setType(productType.getType());
        return productTypeDto;
    }
}
