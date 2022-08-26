package com.tinqin.estate.core.processor;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.error.EstateNotFoundError;
import com.tinqin.estate.api.error.OperationFailedError;
import com.tinqin.estate.api.error.UserNotFoundError;
import com.tinqin.estate.api.model.estate.EstateRequest;
import com.tinqin.estate.api.model.estate.EstateResponse;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressRequest;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressResponse;
import com.tinqin.estate.api.model.estateByAddress.EstateModel;
import com.tinqin.estate.api.operation.EstateByAddressProcessor;
import com.tinqin.estate.core.converter.EstateToEstateResponseConverter;
import com.tinqin.estate.core.exception.EstateNotFoundException;
import com.tinqin.estate.domain.data.entity.Estate;
import com.tinqin.estate.domain.data.repository.EstateRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstateByAddressProcessorCore implements EstateByAddressProcessor {
    private final ConversionService conversionService;
    private final EstateRepo estateRepo;

    public EstateByAddressProcessorCore(ConversionService conversionService, EstateRepo estateRepo) {
        this.conversionService = conversionService;
        this.estateRepo = estateRepo;
    }

    @Override
    public Either<Error, EstateByAddressResponse> process(EstateByAddressRequest input) {
        return Try.of(()->{
            final Estate estate = estateRepo.findEstateByAddress(input.getAddress())
                    .orElseThrow(EstateNotFoundException::new);
            return EstateByAddressResponse.builder()
                    .estates(estateRepo.findEstateByAddress(input.getAddress()).stream()
                            .map(e->conversionService.convert(e, EstateModel.class))
                            .collect(Collectors.toList()))
                    .build();
                }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof  EstateNotFoundException){
                        return new EstateNotFoundError();
                    }
                    return new OperationFailedError();
                });
    }

}
