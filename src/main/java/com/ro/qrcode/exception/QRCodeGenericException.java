package com.ro.qrcode.exception;

public class QRCodeGenericException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1461468847514303675L;
	private String message;

	public QRCodeGenericException(String message) {
		super();
		this.message = message;
	}
	
	public QRCodeGenericException() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
	
}
