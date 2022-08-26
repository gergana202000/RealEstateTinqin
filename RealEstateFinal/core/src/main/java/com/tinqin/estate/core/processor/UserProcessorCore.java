package com.tinqin.estate.core.processor;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.error.EstateNotFoundError;
import com.tinqin.estate.api.error.OperationFailedError;
import com.tinqin.estate.api.error.UserNotFoundError;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressResponse;
import com.tinqin.estate.api.model.estateByAddress.EstateModel;
import com.tinqin.estate.api.model.user.UserRequest;
import com.tinqin.estate.api.model.user.UserResponse;
import com.tinqin.estate.api.model.userByUsername.UserByUsernameRequest;
import com.tinqin.estate.api.model.userByUsername.UserByUsernameResponse;
import com.tinqin.estate.api.model.userByUsername.UserModel;
import com.tinqin.estate.api.operation.UserProcessor;
import com.tinqin.estate.core.exception.EstateNotFoundException;
import com.tinqin.estate.core.exception.UserNotFoundException;
import com.tinqin.estate.domain.data.entity.Estate;
import com.tinqin.estate.domain.data.entity.User;
import com.tinqin.estate.domain.data.repository.UserRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserProcessorCore implements UserProcessor {
    private final ConversionService conversionService;
    private final UserRepo userRepo;

    public UserProcessorCore(ConversionService conversionService, UserRepo userRepo) {
        this.conversionService = conversionService;
        this.userRepo = userRepo;
    }

    @Override
    public Either<Error, UserByUsernameResponse> process(UserByUsernameRequest input) {
        return Try.of(()->{
                    final User user = userRepo.findUserByUsername(input.getUsername())
                            .orElseThrow(UserNotFoundException::new);
                    return UserByUsernameResponse.builder()
                            .users(userRepo.findUserByUsername(input.getUsername())
                                    .stream()
                                    .map(u->conversionService.convert(user, UserModel.class))
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
