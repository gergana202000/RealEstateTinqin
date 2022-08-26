package com.tinqin.estate.rest.controller;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.model.estate.EstateRequest;
import com.tinqin.estate.api.model.estate.EstateResponse;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressRequest;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressResponse;
import com.tinqin.estate.api.operation.EstateByAddressProcessor;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HomeController {
    private final EstateByAddressProcessor estateByAddressProcessor;

    public HomeController(EstateByAddressProcessor estateByAddressProcessor) {
        this.estateByAddressProcessor = estateByAddressProcessor;
    }

    @PostMapping("/estateByAddress")
    public ResponseEntity<?> getEstateByAddress(@RequestBody EstateByAddressRequest estateByAddressRequest){
        Either<Error, EstateByAddressResponse> response = estateByAddressProcessor.process(estateByAddressRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }
}
