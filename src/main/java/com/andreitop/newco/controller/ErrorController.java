package com.andreitop.newco.controller;

import com.andreitop.newco.dto.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {
    private Logger log= LoggerFactory.getLogger(getClass());

    public ErrorController() {
        super();
    }

    @Override
    protected final ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        log.info("Bad request: {}" ,ex.getMessage());
        log.debug("Bad request: ", ex);

        final ApiError apiError=new ApiError(status.value(), ex.getMessage());
        return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected final ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.info("Method not supported: {}", ex.getMessage());
        log.debug("Method not supported: ", ex);

        final ApiError apiError=new ApiError(status.value(), ex.getMessage());
        return handleExceptionInternal(ex, apiError, headers, HttpStatus.METHOD_NOT_ALLOWED, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(
            MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.info("Missing path variable: {}", ex.getMessage());
        log.debug("Missing path variable: ", ex);

        final ApiError apiError=new ApiError(status.value(), ex.getMessage());
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

}
