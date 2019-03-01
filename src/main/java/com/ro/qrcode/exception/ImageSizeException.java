package com.ro.qrcode.exception;

public class ImageSizeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -101167974352707648L;
	String message = "";
	
	public ImageSizeException () {}
	
	public ImageSizeException(final String m) {
		this.message = m;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	
}
