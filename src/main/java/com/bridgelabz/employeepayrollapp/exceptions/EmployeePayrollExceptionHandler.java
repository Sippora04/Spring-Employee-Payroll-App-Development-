package com.bridgelabz.employeepayrollapp.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

/*@ControllerAdvice which will intercept
 * all the controllers and look for the
 * exceptions thrown.
 */
@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {

	public static final String message = "Exception while processing REST request";

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException exception) {
		log.error("Invalid Date Format", exception);
		ResponseDTO resDTO = new ResponseDTO(message, "Should have a date in the format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO resDTO = new ResponseDTO("Exception while processing REST request", errMsg);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception) {
		ResponseDTO resDTO = new ResponseDTO("Exception while processing REST request", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.BAD_REQUEST);
	}

}