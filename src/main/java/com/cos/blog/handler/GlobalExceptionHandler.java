package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	@ExceptionHandler(value=IllegalArgumentException.class)
	public String handlerArgumentException(IllegalArgumentException e) {
		return "<h1> handlerArgumentException " + e.getMessage() + "</h1>";
	}

	@ExceptionHandler(value=Exception.class)
	public String handlerException(Exception e) {
		return "<h1> handlerException " + e.getMessage() + "</h1>";
	}
}
