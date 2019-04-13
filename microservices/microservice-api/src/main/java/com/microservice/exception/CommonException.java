package com.microservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonException extends RuntimeException {

    private String errorCode = "0";

    private String message;

    public CommonException(String message){
        super(message);
    }

}
