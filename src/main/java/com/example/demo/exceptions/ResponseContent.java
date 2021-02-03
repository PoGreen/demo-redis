package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ResponseContent<T> {

    private HttpStatus httpStatus;

    private String message;

    private Date date;

    private T data;


    public ResponseContent(Date date, HttpStatus httpStatus, String message, T data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.date = date;
        this.data = data;
    }

    public ResponseContent(Date date, HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.date = date;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
