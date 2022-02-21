package com.example.ksmapi.controller.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseDeal {
    HttpHeaders hearders = null;

    public ResponseDeal() {
        super();
        hearders = new HttpHeaders();
        hearders.add("Responded","myController");
    }
    public ResponseEntity successful(Object object){
        return ResponseEntity.accepted().headers(hearders).body(object);
    }
    public ResponseEntity fail(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hearders).body("Wrong request");
    }
    public ResponseEntity notAllowed(){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).headers(hearders).body("Permission failed!");
    }

}
