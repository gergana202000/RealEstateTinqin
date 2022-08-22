package com.tinqin.estate.core.processor;

import com.tinqin.estate.api.base.Error;
import com.tinqin.estate.api.model.user.UserRequest;
import com.tinqin.estate.api.model.user.UserResponse;
import com.tinqin.estate.api.operation.UserProcessor;
import io.vavr.control.Either;

public class UserProcessorCore implements UserProcessor {
    @Override
    public Either<Error, UserResponse> process(UserRequest input) {
        return null;
    }
}
