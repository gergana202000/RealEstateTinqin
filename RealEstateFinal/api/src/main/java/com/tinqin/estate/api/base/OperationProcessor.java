package com.tinqin.estate.api.base;

import io.vavr.control.Either;

public interface OperationProcessor <I extends OperationInput, R extends OperationOutput>{
    Either<Error, R> process(I input);
}
