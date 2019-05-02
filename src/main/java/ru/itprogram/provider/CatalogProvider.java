package ru.itprogram.provider;

import ru.itprogram.entity.dto.ProductDto;
import ru.itprogram.service.ProductService;

import java.util.List;

public class CatalogProvider {
    private List<ProductDto> productDtoList;

    public CatalogProvider() {
        productDtoList = new ProductService().getAll();
    }

    public void print() {
        for (ProductDto productDto : productDtoList) {
            System.out.println("ID продукта: [" + productDto.getId()
                    + "] Бренд: [" + productDto.getBrandDto().getName()
                    + "] Тип продукта: [" + productDto.getProductTypeDto()
                    + "] Описание продукта: [" + productDto.getDescription()
                    + "] Гарантия на продукт: [" + productDto.getWarranty()
                    + "] Цена продукта: [" + productDto.getPrice()
                    + "] Скидка на продукт: [" +productDto.getPromoCodeDto().getDiscount());
        }
    }
}
