package com.ro.qrcode.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ro.qrcode.exception.ImageSizeException;
import com.ro.qrcode.exception.QRCodeGenericException;

@RestControllerAdvice
public class QRCodeExceptionHandler {

	@RequestMapping(produces=MediaType.TEXT_PLAIN_VALUE)
	@ExceptionHandler({ImageSizeException.class, QRCodeGenericException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String qrcodeExceptionHandler(RuntimeException ise) {
		
		return (ise.getMessage());
	}
}
