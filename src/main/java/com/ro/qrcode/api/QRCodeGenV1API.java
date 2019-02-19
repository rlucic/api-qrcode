package com.ro.qrcode.api;


import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ro.qrcode.model.QRCodeModel;

import io.swagger.annotations.Api;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

 
/**
 * Version V1 uses the qrgen library for generating the QR Code:com.github.kenglxn;
 * 
 * @author rlucic
 *
 */
@Api
@RestController
@RequestMapping("/image/v1")
public class QRCodeGenV1API {

	@Value("${qrcode.size:200}")
	private int imgSize;
	
	private final String textForQRCode = "Testing QR Code generation with net.glxn.qrgen.javase.QRCode library.";
	
	/**
	 * Testing endpoint for generating a test QR code image. Will return the image itself.
	 * Image type: PNG
	 * 
	 * @return
	 */
	@GetMapping(value="/test/png", produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] ping() {
		
		LocalDateTime ldt = LocalDateTime.now();
		ByteArrayOutputStream baos = QRCode.from("Testing QR Code generation with net.glxn.qrgen.javase.QRCode library, at " +
					ldt.toString()).
				withSize(imgSize, imgSize).to(ImageType.PNG).stream();
		
		return baos.toByteArray();
	}

	/**
	 * Testing endpoint for generating a test QR code image encoded as Base64.
	 * Encoded image type: PNG.
	 * 
	 * @return String as Base64 encodinng of the QR code.
	 */
	@GetMapping(value="/test/b64", produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String pingb64() {
		ByteArrayOutputStream baos = QRCode.from(textForQRCode).
				withSize(imgSize, imgSize).
				to(ImageType.PNG).
				stream();
		
		String toReturn = Base64.getEncoder().encodeToString(baos.toByteArray());
		
		return toReturn;
	}
	
	@PostMapping(value="/generate/png", 
			produces=MediaType.TEXT_PLAIN_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> generateQRCode(@RequestBody QRCodeModel model) {
		if (model==null || model.getText() == null || model.getText().isEmpty() ) {
			return new ResponseEntity<String>("No valid model passed", HttpStatus.BAD_REQUEST);
		}
		System.out.println("request made: " + model.toString());
		ByteArrayOutputStream baos = QRCode.from(model.getText()).
				withSize(imgSize, imgSize).
				to(ImageType.PNG).
				stream();
		
		String toReturn = Base64.getEncoder().encodeToString(baos.toByteArray());		
		return new ResponseEntity<String>(toReturn, HttpStatus.OK);
	}
	
}
