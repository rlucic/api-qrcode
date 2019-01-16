package com.ro.qrcode.api;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	@GetMapping(value="/ping")
	@ApiOperation(value="Checks if application is up. Used as a Kubernetes health check.", response=String.class)
	@ApiResponses(value= {
		@ApiResponse(message="Application up and running", code=200),
		@ApiResponse(message="Application didn't start", code=500)
		}	
	)
	public String ping() {
		final LocalDateTime ldt = LocalDateTime.now();

		logger.info("pong from api-qrcode, @" + ldt.toString());
		return "pong from api-qrcode, @" + ldt.toString();
	}
}
