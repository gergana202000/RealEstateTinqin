package com.tinqin.estate.core.converter;

import com.tinqin.estate.api.model.soldEstateByCity.SoldEstateByCityResponse;
import com.tinqin.estate.domain.data.entity.Estate;
import com.tinqin.estate.domain.data.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EstateToSoldEstateByCityConverter implements Converter<Estate, SoldEstateByCityResponse> {


    @Override
    public SoldEstateByCityResponse convert(Estate source) {
        return SoldEstateByCityResponse.builder()
                .userFirstName(source.getUser().getName())
                .userLastName(source.getUser().getLastName())
                .estateName(source.getEstateName())
                .build();
    }
}
