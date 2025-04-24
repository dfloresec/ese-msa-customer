package ec.com.customer.handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ec.com.customer.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ControllerAdvice
public class ControlExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	private ResponseEntity<Object> handlerException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString()).body("ERROR INTERNO");
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<Object> handlerEntityNotFoundException(ResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString()).body(ex.getMessage());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolationException(ConstraintViolationException exception) {

		List<Map<String, String>> errorDetails = exception.getConstraintViolations().stream()
				.map(violation -> Map.of(violation.getPropertyPath().toString(), violation.getMessage()))
				.collect(Collectors.toList());

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
