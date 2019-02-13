package com.ro.qrcode.api;


import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

@Api
@RestController
@RequestMapping("/image/v1")
public class QRCodeGenV1API {

	
	@GetMapping(value="/test", produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] ping() {
		
		LocalDateTime ldt = LocalDateTime.now();
		ByteArrayOutputStream baos = QRCode.from("Testing QR Code generation with net.glxn.qrgen.javase.QRCode library, at " +
					ldt.toString()).
				withSize(150, 150).to(ImageType.PNG).stream();
		
		return baos.toByteArray();
	}
}
