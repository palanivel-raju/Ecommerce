package org.example.ecommerce.Controller;

import org.example.ecommerce.DTOs.ExceptionDTO;
import org.example.ecommerce.Models.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({IllegalAccessError.class, IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<ExceptionDTO> handleException(Exception ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(ex.getMessage());
        exceptionDTO.setStatus(Status.Failed);
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
