package ru.itprogram.service;

import ru.itprogram.entity.dao.Product;
import ru.itprogram.entity.dto.ProductDto;
import ru.itprogram.repository.ProductRepository;
import ru.itprogram.service.converter.product.ProductDtoToProduct;
import ru.itprogram.service.converter.product.ProductToProductDto;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements Service<ProductDto> {
    @Override
    public List<ProductDto> getAll() {
        List<Product> products = new ProductRepository().getAllEntity();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : products) {
            productDtoList.add(new ProductToProductDto().conversion(product));
        }
        return productDtoList;
    }

    @Override
    public void add(ProductDto productDto) {
        new ProductRepository().saveEntity(new ProductDtoToProduct().conversion(productDto));
    }
}
