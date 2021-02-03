package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class Response{

    public static  <T> ResponseEntity<ResponseContent<T>> ok(T data) {
        ResponseContent<T> responseContentDetail = new ResponseContent<T>(new Date(),HttpStatus.OK, HttpMessage.SUCCESS, data);
        return ResponseEntity.ok().body(responseContentDetail);
    }
    public static <T> ResponseEntity<ResponseContent<T>> ok() {
        ResponseContent<T> responseContentDetail = new ResponseContent<>(new Date(),HttpStatus.OK, HttpMessage.SUCCESS);
        return ResponseEntity.ok().body(responseContentDetail);
    }

    public static <T> ResponseEntity<ResponseContent<T>> badRequest(String message) {
        ResponseContent<T> responseContentDetail = new ResponseContent<>(new Date(),HttpStatus.BAD_REQUEST, message);
        return ResponseEntity.badRequest().body(responseContentDetail);
    }

    public static <T> ResponseEntity<ResponseContent<T>> badRequest(T data) {
        ResponseContent<T> responseContentDetail = new ResponseContent<T>(new Date(),HttpStatus.BAD_REQUEST, HttpMessage.ID_NOT_VALID, data);
        return ResponseEntity.badRequest().body(responseContentDetail);
    }

}
