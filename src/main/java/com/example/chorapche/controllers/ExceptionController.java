package com.example.chorapche.controllers;

import com.example.chorapche.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFound(){
        return "404";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex){return "error";}
}
