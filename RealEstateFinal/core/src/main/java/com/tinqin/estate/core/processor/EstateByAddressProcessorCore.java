package com.tinqin.estate.core.processor;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.error.UserNotFoundError;
import com.tinqin.estate.api.model.estate.EstateRequest;
import com.tinqin.estate.api.model.estate.EstateResponse;
import com.tinqin.estate.api.operation.EstateByAddressProcessor;
import com.tinqin.estate.core.exception.EstateNotFoundException;
import com.tinqin.estate.domain.data.entity.Estate;
import com.tinqin.estate.domain.data.repository.EstateRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class EstateByAddressProcessorCore implements EstateByAddressProcessor {
    private final ConversionService conversionService;
    private final EstateRepo estateRepo;

    public EstateByAddressProcessorCore(ConversionService conversionService, EstateRepo estateRepo) {
        this.conversionService = conversionService;
        this.estateRepo = estateRepo;
    }

    @Override
    public Either<Error, EstateResponse> process(EstateRequest input) {
        return Try.of(()->{
            final Estate estate = estateRepo.findEstateByAddress(input.getAddress())
                    .orElseThrow(EstateNotFoundException::new);
            return conversionService.convert(estate, EstateResponse.class);
        }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof EstateNotFoundException){
                        return new UserNotFoundError();
                    }
                    return new UserNotFoundError();
                })
                ;
    }

}
