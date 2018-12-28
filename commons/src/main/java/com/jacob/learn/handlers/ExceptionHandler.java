package com.jacob.learn.handlers;

import com.jacob.learn.exceptions.BusinessException;
import com.jacob.learn.response.RestRespond;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = BusinessException.class)
    public RestRespond handleBaseException(BusinessException e) {
        log.error(e.getMessage(), e);
        return getResp(e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public RestRespond handleException(Exception e) {
        log.error(e.getMessage(), e);
        return getResp(e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public RestRespond handleConstraintViolationException(ConstraintViolationException e) {
        Set<String> errors = e.getConstraintViolations().stream()
                .map(item -> item.getMessage())
                .collect(Collectors.toSet());
        return getResp(errors);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RestRespond handleArgsException(MethodArgumentNotValidException e) {
        Map<String, String> errors = e.getBindingResult().getAllErrors().stream()
                .map(item -> (FieldError) item)
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return getResp(errors);
    }

    private RestRespond getResp(Object error) {
        RestRespond respond = new RestRespond();
        respond.setSuccess(false);
        respond.setMsg(error);
        return respond;
    }
}
