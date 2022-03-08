package com.RestfulService1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpNotFound extends RuntimeException{

    public EmpNotFound(String s) {
        super(s);
    }
}
