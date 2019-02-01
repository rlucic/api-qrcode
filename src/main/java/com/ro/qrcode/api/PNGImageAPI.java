package com.ro.qrcode.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


@Api
@RestController
@RequestMapping("/image")
public class PNGImageAPI {

	@GetMapping(value="/getpng/{img}", produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] returnPNGImage(@PathVariable(value="img") String imageName) throws IOException{
		String theName = imageName+".png";
		System.out.println("retrieving image from: " + theName);
		ClassPathResource classPathResource = new ClassPathResource(theName);
		InputStream in = classPathResource.getInputStream();
		return IOUtils.toByteArray(in);
	}
	
	
//	@GetMapping(value="/getb64/{name}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@GetMapping(value="/getb64/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String returnBase64EncodedImage(@PathVariable(value="name") String imageName) throws IOException{
		String theName = imageName+".png";
		System.out.println("retrieving image from: " + theName);
		ClassPathResource classPathResource = new ClassPathResource(theName);
		InputStream in = classPathResource.getInputStream();
		
		//String encodedfile = new String(Base64.encodeBase64(IOUtils.toByteArray(in)), "UTF-8");
		
		return new String(Base64.getEncoder().encodeToString(IOUtils.toByteArray(in)));
		//return new String(IOUtils.toByteArray(in));
	}

}
