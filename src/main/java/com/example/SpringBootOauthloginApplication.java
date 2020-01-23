package com.example;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootOauthloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauthloginApplication.class, args);
	}

	@GetMapping("/")
	public Authentication getAuthentication(Authentication authentication) {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println(grantedAuthority.getAuthority());
		}
		return authentication;
	}

}