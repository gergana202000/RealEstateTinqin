package com.tinqin.estate.core.processor;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.error.EstateNotFoundError;
import com.tinqin.estate.api.model.estate.EstateRequest;
import com.tinqin.estate.api.model.estate.EstateResponse;
import com.tinqin.estate.api.operation.EstateByAddressProcessor;
import com.tinqin.estate.domain.data.entity.Estate;
import com.tinqin.estate.domain.data.repository.EstateRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EstateByAddressProcessorCore implements EstateByAddressProcessor {
    private final EstateRepo estateRepo;

    public EstateByAddressProcessorCore(EstateRepo estateRepo) {
        this.estateRepo = estateRepo;
    }

    @Override
    public Either<Error, EstateResponse> process(EstateRequest input) {
        return null;
    }

   /* @Override
    public Either<Error, EstateResponse> process(EstateRequest input) {
        return Try.of(()->{
            final
        });
        return Try.of(()->{
            final Optional<Estate> estate = estateRepo.findEstateByAddress(input.getEstateName());
            return EstateResponse.builder()
                    .address("Varna")
                    .build();
        }).toEither()
                .mapLeft(throwable -> {
                    return new EstateNotFoundError();
                });*/
    }
}
