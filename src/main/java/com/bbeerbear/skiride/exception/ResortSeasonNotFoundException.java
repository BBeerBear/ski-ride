package com.bbeerbear.skiride.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResortSeasonNotFoundException extends RuntimeException {

    public ResortSeasonNotFoundException(String message) {
        super(message);
    }
}
