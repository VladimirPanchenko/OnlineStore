package ru.itprogram.service.converter.promocode;

import ru.itprogram.entity.dao.PromoCode;
import ru.itprogram.entity.dto.PromoCodeDto;
import ru.itprogram.repository.PromoCodeRepository;
import ru.itprogram.service.converter.Converter;

import java.util.List;

public class PromoCodeDtoToPromoCode implements Converter<PromoCode, PromoCodeDto> {
    @Override
    public PromoCode conversion(PromoCodeDto promoCodeDto) {
        PromoCode promoCode = new PromoCode();
        promoCode.setId(getIdPromoCode(promoCodeDto));
        promoCode.setCode(promoCodeDto.getCode());
        promoCode.setDiscount(promoCode.getDiscount());
        return promoCode;
    }

    private int getIdPromoCode(PromoCodeDto promoCodeDto) {
        List<PromoCode> promoCodes = new PromoCodeRepository().getAllEntity();
        return getId(promoCodes, promoCodeDto);
    }

    private int getId(List<PromoCode> promoCodes, PromoCodeDto promoCodeDto) {
        int tempId = 0;
        for (PromoCode promoCode : promoCodes){
            if (promoCode.getCode().equals(promoCodeDto.getCode())
                    && promoCode.getDiscount() == promoCodeDto.getDiscount()) {
                tempId = promoCode.getId();
            }
        }
        return tempId;
    }
}
