package com.tinqin.estate.api.error;

import com.tinqin.estate.api.base.Error;
import org.springframework.http.HttpStatus;

public class EstateNotFoundError implements Error {
    @Override
    public HttpStatus getCode() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return "Estate not found!";
    }
}
