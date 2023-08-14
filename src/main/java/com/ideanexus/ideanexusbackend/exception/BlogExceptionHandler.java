package com.ideanexus.ideanexusbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(value = {BlogNotFoundException.class})
    public ResponseEntity<Object> handleBlogNotFoundExeption(BlogNotFoundException blogNotFoundException){

        // Create payload containing exception details
        ApiException apiException = new ApiException(
                blogNotFoundException.getMessage(),
                blogNotFoundException,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        // Return Response Entity

        return new ResponseEntity<>(apiException,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {DataBadRequestException.class})
    public ResponseEntity<Object> handleBlogBadRequestException(DataBadRequestException dataBadRequestException){
        ApiException apiException = new ApiException(
                dataBadRequestException.getMessage(),
                dataBadRequestException,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }





}
