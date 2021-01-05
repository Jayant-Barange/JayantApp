package com.cts.truyum.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.truyum.order.model.AuthResponse;

//@FeignClient(url = "localhost:8000/authapp", name = "TRUYUM-AUTH")
@FeignClient(name = "TRUYUM-AUTH", url = "${feign.url-auth-service}")
public interface AuthClient {

	@RequestMapping(path = "/validate", method = RequestMethod.GET)
	public AuthResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
