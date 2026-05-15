package com.facens.pet.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<String> tratarErro(
            RegraNegocioException ex
    ){

        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());

    }

}