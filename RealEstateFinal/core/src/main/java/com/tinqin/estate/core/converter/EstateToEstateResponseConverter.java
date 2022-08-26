package com.tinqin.estate.core.converter;

import com.tinqin.estate.api.model.estate.EstateResponse;
import com.tinqin.estate.domain.data.entity.Estate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EstateToEstateResponseConverter implements Converter<Estate, EstateResponse> {
    @Override
    public EstateResponse convert(Estate source) {
        return EstateResponse.builder()
                .estateName(source.getEstateName())
                .price(source.getPrice())
                .size(source.getSize())
                .build();
    }
}
