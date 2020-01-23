package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author deepakk
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/favicon.ico/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.oauth2Login();
		// @formatter:on

	}

}
