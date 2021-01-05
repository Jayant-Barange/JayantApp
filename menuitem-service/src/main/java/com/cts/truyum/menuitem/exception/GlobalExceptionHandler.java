package com.cts.truyum.menuitem.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.truyum.menuitem.model.CustomErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MenuItemNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundMenuItemErrors(MenuItemNotFoundException ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Invalid MenuItem Id Provided");
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MenuItemAlreadyExistException.class)
	public ResponseEntity<CustomErrorResponse> handleConfilctError(MenuItemAlreadyExistException ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.CONFLICT);
		response.setReason("Invalid MenuItem Id Provided");
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(InvalidMenuItem.class)
	public ResponseEntity<CustomErrorResponse> handleConfilctError(InvalidMenuItem ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.CONFLICT);
		response.setReason("Invalid MenuItem");
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.CONFLICT);
	}
	@ExceptionHandler(MenuItemNotAvailableException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundMenuItemErrors(MenuItemNotAvailableException ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.CONFLICT);
		response.setReason("MenuItem is not available");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.CONFLICT);
	}
}
