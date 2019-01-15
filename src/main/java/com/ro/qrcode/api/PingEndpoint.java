package com.ro.qrcode.api;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingEndpoint {
	
	@GetMapping(value="/ping")
	public String ping() {
		final LocalDateTime ldt = LocalDateTime.now();
		
		return "pong from api-qrcode, @" + ldt.toString();
	}
}
