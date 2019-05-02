package ru.itprogram.service.converter.producttype;

import ru.itprogram.entity.dao.ProductType;
import ru.itprogram.entity.dto.ProductTypeDto;
import ru.itprogram.repository.ProductTypeRepository;
import ru.itprogram.service.converter.Converter;

import java.util.List;

public class ProductTypeDtoToProductType implements Converter<ProductType, ProductTypeDto> {
    @Override
    public ProductType conversion(ProductTypeDto productTypeDto) {
        ProductType productType = new ProductType();
        productType.setId(getIdType(productTypeDto));
        productType.setType(productTypeDto.getType());
        return productType;
    }
    private int getIdType(ProductTypeDto productTypeDto) {
        List<ProductType> productTypes = new ProductTypeRepository().getAllEntity();
        return getId(productTypes, productTypeDto);
    }

    private int getId(List<ProductType> productTypes, ProductTypeDto productTypeDto) {
        int tempId = 0;
        for (ProductType productType : productTypes){
            if (productType.getType().equals(productTypeDto.getType())) {
                tempId = productType.getId();
            }
        }
        return tempId;
    }
}
