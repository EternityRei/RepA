package com.example.repa.controller;

import com.example.repa.dto.ErrorDTO;
import com.example.repa.exception.AlreadyCreatedEntityException;
import com.example.repa.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ErrorDTO entityNotFoundExceptionHandler(EntityNotFoundException exception) {
        return ErrorDTO.builder().id(102).message(exception.getMessage()).build();
    }

    @ExceptionHandler(value = AlreadyCreatedEntityException.class)
    public ErrorDTO alreadyCreatedEntityException(AlreadyCreatedEntityException exception){
        return ErrorDTO.builder().id(110).message(exception.getMessage()).build();
    }
}
