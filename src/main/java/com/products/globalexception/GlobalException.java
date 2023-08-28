package com.products.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.products.customexception.BrandNotFoundException;

@RestControllerAdvice
public class GlobalException {
@ExceptionHandler(BrandNotFoundException.class)
public ResponseEntity<Object> brandHandler() {
	return new ResponseEntity<>("brand not here",HttpStatus.BAD_REQUEST);
}
}
