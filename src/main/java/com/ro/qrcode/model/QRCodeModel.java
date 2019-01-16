package com.ro.qrcode.model;

public class QRCodeModel {

	private String text;
	private String format;
	
	
	public QRCodeModel(String text, String format) {
		super();
		this.text = text;
		this.format = format;
	}
	
	public QRCodeModel() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "QRCodeModel [text=" + text + ", format=" + format + "]";
	}
	
	
}
