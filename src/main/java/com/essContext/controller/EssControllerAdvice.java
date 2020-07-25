package com.essContext.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EssControllerAdvice {

    @ResponseBody
    @ExceptionHandler
    public Map errorHandler(Exception ex) {
        Map map = new HashMap(2);
        map.put("code", 99999);
        map.put("message", ex.getMessage());
        return map;
    }
}
