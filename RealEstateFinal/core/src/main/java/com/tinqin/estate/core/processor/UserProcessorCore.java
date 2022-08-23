package com.tinqin.estate.core.processor;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.error.UserNotFoundError;
import com.tinqin.estate.api.model.user.UserRequest;
import com.tinqin.estate.api.model.user.UserResponse;
import com.tinqin.estate.api.operation.UserProcessor;
import com.tinqin.estate.core.exception.UserNotFoundException;
import com.tinqin.estate.domain.data.entity.User;
import com.tinqin.estate.domain.data.repository.UserRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;

public class UserProcessorCore implements UserProcessor {
    private final ConversionService conversionService;
    private final UserRepo userRepo;

    public UserProcessorCore(ConversionService conversionService, UserRepo userRepo) {
        this.conversionService = conversionService;
        this.userRepo = userRepo;
    }

    @Override
    public Either<Error, UserResponse> process(UserRequest input) {
        return Try.of(()->{
            final User user = userRepo.findUserByUsername(input.getUsername())
                    .orElseThrow(UserNotFoundException::new);
            return conversionService.convert(user, UserResponse.class);
        }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof UserNotFoundException){
                        return new UserNotFoundError();
                    }
                    return new UserNotFoundError();
                        });
    }
}
