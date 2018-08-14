package com.denlex.superoptimum.config;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.Role;
import com.denlex.superoptimum.service.user.DistributorService;
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
@Order(1)
public class DistributorSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private DistributorService distributorService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http
//				.antMatcher("/distributor/**").authorizeRequests().anyRequest().permitAll().and()
				.formLogin()
					.loginPage("/distributor/login")
					.loginProcessingUrl("/login_distributor")
					.failureUrl("/distributor/login?error=loginError")
					.defaultSuccessUrl("/distributor/index_distributor")
					.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			Credentials credentials = distributorService.findCredentialsByUsername(username);
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

			for (Role role : credentials.getRoles()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			}

			return new org.springframework.security.core.userdetails.User(credentials.getUsername(), credentials.getPassword(), grantedAuthorities);
		}).passwordEncoder(bCryptPasswordEncoder());
	}
}
