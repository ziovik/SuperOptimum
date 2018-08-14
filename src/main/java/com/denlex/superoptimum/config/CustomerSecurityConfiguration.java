package com.denlex.superoptimum.config;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.Role;
import com.denlex.superoptimum.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 14.08.18.
 */
@Configuration
@Order(2)
public class CustomerSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private CustomerService customerService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http
//				.antMatcher("/customer/**").authorizeRequests().anyRequest().authenticated().and()
				.formLogin()
					.loginPage("/customer/login")
					.loginProcessingUrl("/login_customer")
					.failureUrl("/customer/login?error=loginError")
					.defaultSuccessUrl("/customer/optimum_beauty")
					.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			Credentials credentials = customerService.findCredentialsByUsername(username);
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

			for (Role role : credentials.getRoles()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			}

			return new org.springframework.security.core.userdetails.User(credentials.getUsername(), credentials.getPassword(), grantedAuthorities);
		}).passwordEncoder(bCryptPasswordEncoder());
	}
}
