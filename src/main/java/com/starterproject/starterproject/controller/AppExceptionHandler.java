package com.starterproject.starterproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.Serializable;
import java.time.LocalTime;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request)
//    {
//        return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request)
//    {
//        return new ResponseEntity<>(new CustomRestException(ex, request), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    public class CustomRestException extends Exception implements Serializable {
        LocalTime timeStamp;
        Integer status;
        String path;
        String error;
        String errorMessage;

        public CustomRestException(Exception ex, WebRequest request) {
            this.timeStamp = LocalTime.now();
            this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            this.path = request.getContextPath();
            this.error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            this.errorMessage = ex.getMessage();
        }

        @Override
        public String toString() {
            return "CustomRestException{" +
                    "timeStamp=" + timeStamp +
                    ", status=" + status +
                    ", path='" + path + '\'' +
                    ", error='" + error + '\'' +
                    ", errorMessage='" + errorMessage + '\'' +
                    '}';
        }
    }
}
