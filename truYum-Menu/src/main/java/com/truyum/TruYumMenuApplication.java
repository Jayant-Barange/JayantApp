package com.truyum;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class TruYumMenuApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TruYumMenuApplication.class, args);
		
	}

}
