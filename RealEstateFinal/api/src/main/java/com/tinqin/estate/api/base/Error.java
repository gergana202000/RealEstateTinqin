package com.tinqin.estate.api.base;

import org.springframework.http.HttpStatus;

public interface Error {
    HttpStatus getCode();
    String getMessage();
}
