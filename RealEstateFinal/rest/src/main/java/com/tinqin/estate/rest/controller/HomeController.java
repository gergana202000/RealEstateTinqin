package com.tinqin.estate.rest.controller;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.model.contractByNumber.ContractByNumberRequest;
import com.tinqin.estate.api.model.contractByNumber.ContractByNumberResponse;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressRequest;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressResponse;
import com.tinqin.estate.api.model.user.UserRequest;
import com.tinqin.estate.api.model.user.UserResponse;
import com.tinqin.estate.api.model.userByUsername.UserByUsernameRequest;
import com.tinqin.estate.api.model.userByUsername.UserByUsernameResponse;
import com.tinqin.estate.api.operation.ContractByNumberProcessor;
import com.tinqin.estate.api.operation.EstateByAddressProcessor;
import com.tinqin.estate.api.operation.UserProcessor;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HomeController {
    private final EstateByAddressProcessor estateByAddressProcessor;
    private final ContractByNumberProcessor contractByNumberProcessor;
    private final UserProcessor userProcessor;

    public HomeController(EstateByAddressProcessor estateByAddressProcessor, ContractByNumberProcessor contractByNumberProcessor, UserProcessor userProcessor) {
        this.estateByAddressProcessor = estateByAddressProcessor;
        this.contractByNumberProcessor = contractByNumberProcessor;
        this.userProcessor = userProcessor;
    }

    @PostMapping("/estateByAddress")
    public ResponseEntity<?> getEstateByAddress(@RequestBody EstateByAddressRequest estateByAddressRequest){
        Either<Error, EstateByAddressResponse> response = estateByAddressProcessor.process(estateByAddressRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }

    @PostMapping("/contractByNumber")
    public ResponseEntity<?> getContractByNumber(@RequestBody ContractByNumberRequest contractByNumberRequest){
        Either<Error, ContractByNumberResponse> response = contractByNumberProcessor.process(contractByNumberRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    };


    @PostMapping("/userByUsername")
    private ResponseEntity<?> getUserByUsername(@RequestBody UserByUsernameRequest userByUsernameRequest){
        Either<Error, UserByUsernameResponse> response = userProcessor.process(userByUsernameRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }
}
