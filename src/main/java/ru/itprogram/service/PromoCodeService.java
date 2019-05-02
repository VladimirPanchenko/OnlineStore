package ru.itprogram.service;

import ru.itprogram.entity.dao.PromoCode;
import ru.itprogram.entity.dto.PromoCodeDto;
import ru.itprogram.repository.PromoCodeRepository;
import ru.itprogram.service.converter.promocode.PromoCodeDtoToPromoCode;
import ru.itprogram.service.converter.promocode.PromoCodeToPromoCodeDto;

import java.util.ArrayList;
import java.util.List;

public class PromoCodeService implements Service<PromoCodeDto> {
    @Override
    public List<PromoCodeDto> getAll() {
        List<PromoCode> promoCodes = new PromoCodeRepository().getAllEntity();
        List<PromoCodeDto> promoCodeDtoList = new ArrayList<>();
        for (PromoCode promoCode : promoCodes) {
            promoCodeDtoList.add(new PromoCodeToPromoCodeDto().conversion(promoCode));
        }
        return promoCodeDtoList;
    }

    @Override
    public void add(PromoCodeDto promoCodeDto) {
        new PromoCodeRepository().saveEntity(
                new PromoCodeDtoToPromoCode().conversion(promoCodeDto));
    }
}
