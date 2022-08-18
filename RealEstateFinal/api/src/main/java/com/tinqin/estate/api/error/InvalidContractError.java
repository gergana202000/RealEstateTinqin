package com.tinqin.estate.api.error;

import com.tinqin.estate.api.base.Error;
import org.springframework.http.HttpStatus;

public class InvalidContractError implements Error {
    @Override
    public HttpStatus getCode() {
        return HttpStatus.NOT_ACCEPTABLE;
    }

    @Override
    public String getMessage() {
        return "Тhe sale cannot be completed!";
    }
}
