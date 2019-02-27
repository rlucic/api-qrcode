package com.ro.qrcode.model;

public class QRCodeModel {

	private String text;
	private int size;
	
	
	public QRCodeModel(String text, int format) {
		super();
		this.text = text;
		this.size = size;
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



	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "QRCodeModel [text=" + text + ", image size=" + size + "pixels]";
	}
	
	
}
