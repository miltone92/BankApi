package com.bbg.bankapi;

import com.bbg.bankapi.config.JWTConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApiApplication {

	public static JWTConfig jwtConfig = new JWTConfig();

	public static void main(String[] args) {
		SpringApplication.run(BankApiApplication.class, args);
	}
 
}
