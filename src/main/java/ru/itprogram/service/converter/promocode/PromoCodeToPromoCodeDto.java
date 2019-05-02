package ru.itprogram.service.converter.promocode;

import ru.itprogram.entity.dao.PromoCode;
import ru.itprogram.entity.dto.PromoCodeDto;
import ru.itprogram.service.converter.Converter;

public class PromoCodeToPromoCodeDto implements Converter<PromoCodeDto, PromoCode> {
    @Override
    public PromoCodeDto conversion(PromoCode promoCode) {
        PromoCodeDto promoCodeDto = new PromoCodeDto();
        promoCodeDto.setCode(promoCode.getCode());
        promoCodeDto.setDiscount(promoCode.getDiscount());
        return promoCodeDto;
    }
}
