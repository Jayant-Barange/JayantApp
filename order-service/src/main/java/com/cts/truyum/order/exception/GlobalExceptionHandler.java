package com.cts.truyum.order.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.truyum.order.model.CustomErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {


	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundUserError(UserNotFoundException ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Invalid User Id Provided");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CartEmptyException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundUserError(CartEmptyException ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Cart is empty");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MenuItemNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundMenuItemErrors(MenuItemNotFoundException ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Invalid MenuItem Id Provided");
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.NOT_FOUND);
	}

}
