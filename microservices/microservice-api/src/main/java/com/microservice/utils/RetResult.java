package com.microservice.utils;

import com.microservice.exception.CommonException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RetResult {

    private static final String SUCCESS_CODE = "1";

    private static final String ERROR_CODE = "0";

    //状态值 1-成功，其他值表示失败
    private String retCode = "1";

    private String message;

    private Object record;

    public RetResult(String retCode,String message){
        this.retCode = retCode;
        this.message = message;
    }

    public static RetResult success(){
        return new RetResult(SUCCESS_CODE,"成功！");
    }

    public static RetResult success(String message){
        return new RetResult(SUCCESS_CODE,message);
    }

    public static RetResult success(String message,Object t){
        return new RetResult(SUCCESS_CODE,message,t);
    }

    public static RetResult success(Object t){
        return new RetResult(SUCCESS_CODE,"成功",t);
    }

    public static RetResult error(){
        return new RetResult(ERROR_CODE,"失败！");
    }

    public static RetResult error(String message){
        return new RetResult(ERROR_CODE,message);
    }

    public static RetResult error(Exception exception){
        if(exception instanceof CommonException){
            return new RetResult(((CommonException) exception).getErrorCode(),exception.getMessage());
        }
        return error();
    }
}
