package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.example.demo.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BasicConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
// Without AntMatcher
/*@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();

	}*/
	
	//with antMatcher
	/* @Override
	protected void configure(HttpSecurity http) throws Exception {

		http.
		authorizeRequests()
		.antMatchers("/public/*")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();

	}*/
	
// Here We are doing Role Based Authentication with hasRole and this we can do this by using annotation also. 
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		.antMatchers("/signin").permitAll()
		.antMatchers("/public/*").hasRole("NORMAL")
		.antMatchers("/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/users/");

	}

// below method for NoOpPasswordEncoder
/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("siddharth").password("google").roles("NORMAL");

	}

	@Bean
	public PasswordEncoder PasswordEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}*/
	
// below method for BCryptPasswordEncoder
@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	auth.userDetailsService(customUserDetailsService).passwordEncoder(PasswordEncoder());
	
	}

	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {

		return new BCryptPasswordEncoder(10);
	}
	


}
