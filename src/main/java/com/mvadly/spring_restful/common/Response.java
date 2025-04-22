package com.mvadly.spring_restful.common;

import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

/*Generic Method*/
@Setter
@Getter
public class Response<T> {
    public String message;
    public String rc = "9999";
    public T data;

    private void internalError(String error) {
        this.rc = "0500";
        this.message = error;
        this.data = null;
        System.out.println("Internal Server Error: "+ error);
    }

    public void success(T data) {
        this.rc = "0000";
        this.data = data;
        this.message = "Success";
    }

    public Response<T> badRequest(String message, T error) {
        this.data = error;
        this.message = message;
        return this;
    }

    public Response<T> Json(String message, T data){
        switch (this.rc) {
            case "0000":
                this.success(data);
                return this;
            case "0400":
                this.badRequest(message, data);
                return this;
            default:
                this.internalError(message);
                return this;
        }
    }

}
