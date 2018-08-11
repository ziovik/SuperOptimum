package com.denlex.superoptimum.config;

import com.denlex.superoptimum.service.user.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created by Shishkov A.V. on 10.08.18.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private CredentialsService credentialsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/", "/index", "/loading_c", "/loading_d").permitAll()
					.antMatchers("/css/**", "/js/**", "/font/**", "/img/**").permitAll()
					.anyRequest().authenticated()
				.and()
					.formLogin().successHandler(authenticationSuccessHandler)
					.loginPage("/login")
					.permitAll()
				.and()
					.logout()
					.permitAll()
				.and()
					.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(credentialsService).passwordEncoder(bCryptPasswordEncoder());
	}
}
