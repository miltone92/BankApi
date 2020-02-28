package com.bbg.authorapi;

import com.bbg.authorapi.config.JWTConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthoapiApplication {

	public static JWTConfig jwtConfig = new JWTConfig();
	public static void main(String[] args) {
		SpringApplication.run(AuthoapiApplication.class, args);
	}
 
}
