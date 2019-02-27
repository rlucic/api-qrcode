package com.ro.qrcode.api;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
public class PingEndpoint {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${prop1:abcd}")
	String prop1;
	
	@GetMapping(value="/ping",  produces=MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value="Checks if application is up. Can be used as a Kubernetes health check.", response=String.class)
	@ApiResponses(value= {
		@ApiResponse(message="Application up and running", code=200),
		@ApiResponse(message="Application didn't start", code=500)
		}
	)
	public ResponseEntity<String> ping() {
		final LocalDateTime ldt = LocalDateTime.now();

		logger.info("pong from api-qrcode, @" + ldt.toString()); 
		logger.info("property from a separate file: {}", prop1);
		
		return new ResponseEntity<>("pong from api-qrcode, @" + ldt.toString(), HttpStatus.OK);
	}
}
