package ru.itprogram.service.converter.product;

import ru.itprogram.entity.dao.Product;
import ru.itprogram.entity.dto.ProductDto;
import ru.itprogram.repository.ProductRepository;
import ru.itprogram.service.converter.Converter;
import ru.itprogram.service.converter.brand.BrandDtoToBrand;
import ru.itprogram.service.converter.producttype.ProductTypeDtoToProductType;
import ru.itprogram.service.converter.promocode.PromoCodeDtoToPromoCode;

import java.util.List;

public class ProductDtoToProduct implements Converter<Product, ProductDto> {
    @Override
    public Product conversion(ProductDto productDto) {
        Product product = new Product();
        product.setId(getIdBrand(productDto));
        product.setBrandId(new BrandDtoToBrand().conversion(productDto.getBrandDto()).getId());
        product.setProductTypeId(new ProductTypeDtoToProductType()
                .conversion(productDto.getProductTypeDto()).getId());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        product.setWarranty(productDto.getWarranty());
        product.setAvailable(productDto.isAvailable());
        product.setPrice(productDto.getPrice());
        product.setPromoCodId(new PromoCodeDtoToPromoCode()
                .conversion(productDto.getPromoCodeDto()).getId());
        return product;
    }

    private int getIdBrand(ProductDto productDto) {
        List<Product> products = new ProductRepository().getAllEntity();
        return getId(products, productDto);
    }

    private int getId(List<Product> products, ProductDto productDto) {
        int tempId = 0;
        for (Product product : products){
            if (product.getBrandId() == new BrandDtoToBrand()
                    .conversion(productDto.getBrandDto()).getId()
                    && product.getProductTypeId() == new ProductTypeDtoToProductType()
                    .conversion(productDto.getProductTypeDto()).getId()
                    && product.getDescription().equals(productDto.getDescription())
                    && product.getQuantity() == productDto.getQuantity()
                    && product.getWarranty() == productDto.getWarranty()
                    && product.isAvailable() == productDto.isAvailable()
                    && product.getPrice() == productDto.getPrice()
                    && product.getPromoCodId() == new PromoCodeDtoToPromoCode()
                    .conversion(productDto.getPromoCodeDto()).getId()) {
                tempId = product.getId();
            }
        }
        return tempId;
    }
}
