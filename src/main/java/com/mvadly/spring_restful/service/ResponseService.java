package com.mvadly.spring_restful.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ResponseService<T> {
    public int statusCode = 404;
    public String message;
    public T data;
    public String rc;

    private ResponseService res;

    ResponseService success(T data) {
        this.statusCode = HttpStatus.OK.value();
        this.message = "Success";
        this.data = data;
        this.rc = "0000";
        return this;
    }

    ResponseService badRequest(String rc, String message, T data) {
        this.statusCode = HttpStatus.BAD_REQUEST.value();
        this.message = message;
        this.data = data;
        this.rc = rc;
        return this;
    }
    
    ResponseService internalServerError(String error) {
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = error;
        this.rc = "0500";
        System.out.println(error);
        return this;
    }
}
