package com.skillnest.cynthia.exception;

import com.skillnest.cynthia.dto.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationException(ValidationException ve) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Validación errónea", ve.getMessage());
        return ResponseEntity.status(ve.getStatus()).body(errorResponse);
    }

}
