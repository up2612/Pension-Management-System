package com.cts.pensioner.detail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PensionerDetailMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailMicroserviceApplication.class, args);
	}

}
