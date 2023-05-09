package dev.edgardomd.challengeidesoft.infraestructure.controller;

import dev.edgardomd.challengeidesoft.infraestructure.exception.GatewayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(GatewayException.class)
    public ResponseEntity<GatewayException> handleError(GatewayException ex) {
        return new ResponseEntity<>(new GatewayException("Error Holiday Api Gateway"), HttpStatus.BAD_GATEWAY);
    }
}
