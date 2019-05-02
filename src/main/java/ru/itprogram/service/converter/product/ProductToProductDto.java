package ru.itprogram.service.converter.product;

import ru.itprogram.entity.dao.Brand;
import ru.itprogram.entity.dao.Product;
import ru.itprogram.entity.dao.ProductType;
import ru.itprogram.entity.dao.PromoCode;
import ru.itprogram.entity.dto.BrandDto;
import ru.itprogram.entity.dto.ProductDto;
import ru.itprogram.entity.dto.ProductTypeDto;
import ru.itprogram.entity.dto.PromoCodeDto;
import ru.itprogram.repository.BrandRepository;
import ru.itprogram.repository.ProductTypeRepository;
import ru.itprogram.repository.PromoCodeRepository;
import ru.itprogram.service.converter.Converter;
import ru.itprogram.service.converter.brand.BrandToBrandDto;
import ru.itprogram.service.converter.producttype.ProductTypeToProductTypeDto;
import ru.itprogram.service.converter.promocode.PromoCodeToPromoCodeDto;

import java.util.List;

public class ProductToProductDto implements Converter<ProductDto, Product> {
    @Override
    public ProductDto conversion(Product product) {
        BrandRepository brandRepository = new BrandRepository();
        List<Brand> brands = brandRepository.getAllEntity();
        BrandDto brandDto = new BrandDto();
        for (Brand brand : brands) {
            if (brand.getId() == product.getBrandId()) {
                brandDto = new BrandToBrandDto().conversion(brand);
            }
        }
        ProductTypeRepository productTypeRepository = new ProductTypeRepository();
        List<ProductType> productTypes = productTypeRepository.getAllEntity();
        ProductTypeDto productTypeDto = new ProductTypeDto();
        for (ProductType productType : productTypes) {
            if (productType.getId() == product.getProductTypeId()) {
                productTypeDto = new ProductTypeToProductTypeDto().conversion(productType);
            }
        }
        PromoCodeRepository promoCodeRepository = new PromoCodeRepository();
        List<PromoCode> promoCodes = promoCodeRepository.getAllEntity();
        PromoCodeDto promoCodeDto = new PromoCodeDto();
        for (PromoCode promoCode : promoCodes) {
            if (promoCode.getId() == product.getPromoCodId()) {
                promoCodeDto = new PromoCodeToPromoCodeDto().conversion(promoCode);
            }
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setBrandDto(brandDto);
        productDto.setProductTypeDto(productTypeDto);
        productDto.setDescription(product.getDescription());
        productDto.setQuantity(product.getQuantity());
        productDto.setWarranty(product.getWarranty());
        productDto.setAvailable(product.isAvailable());
        productDto.setPrice(product.getPrice());
        productDto.setPromoCodeDto(promoCodeDto);
        return productDto;
    }
}
