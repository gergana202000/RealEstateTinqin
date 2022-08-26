package com.tinqin.estate.core.processor;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.error.ContactNotFoundError;
import com.tinqin.estate.api.error.OperationFailedError;
import com.tinqin.estate.api.model.contractByNumber.ContractByNumberRequest;
import com.tinqin.estate.api.model.contractByNumber.ContractByNumberResponse;
import com.tinqin.estate.api.model.contractByNumber.ContractModel;
import com.tinqin.estate.api.operation.ContractByNumberProcessor;
import com.tinqin.estate.core.exception.ContractNotFoundException;
import com.tinqin.estate.domain.data.entity.Contract;
import com.tinqin.estate.domain.data.repository.ContractRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ContractByNumberProcessorCore implements ContractByNumberProcessor {
    private final ConversionService conversionService;
    private final ContractRepo contractRepo;

    public ContractByNumberProcessorCore(ConversionService conversionService, ContractRepo contractRepo) {
        this.conversionService = conversionService;
        this.contractRepo = contractRepo;
    }

    @Override
    public Either<Error, ContractByNumberResponse> process(ContractByNumberRequest input) {
        return Try.of(()-> {
            final Contract contract = contractRepo.findContractByNumber(input.getNumber())
                    .orElseThrow(ContractNotFoundException::new);
            return ContractByNumberResponse.builder()
                    .contracts(contractRepo.findContractByNumber(input.getNumber()).stream()
                            .map(c -> conversionService.convert(c, ContractModel.class))
                            .collect(Collectors.toList()))
                    .build();
        }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof ContractNotFoundException){
                        return new ContactNotFoundError();
                }
                    return new OperationFailedError();
        });
    }
}
