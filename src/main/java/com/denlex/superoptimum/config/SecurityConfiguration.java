package com.denlex.superoptimum.config;

import com.denlex.superoptimum.domain.user.RoleKind;
import com.denlex.superoptimum.service.user.CredentialsService;
import com.denlex.superoptimum.service.user.security.CustomerCredentialsService;
import com.denlex.superoptimum.service.user.security.DistributorCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
public class SecurityConfiguration {
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

	@Autowired
	private CustomerCredentialsService customerCredentialsService;

	@Autowired
	private DistributorCredentialsService distributorCredentialsService;

	@Configuration
	@Order(1)
	public static class CustomerSecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
					.antMatchers("/customer/**").hasRole(RoleKind.CUSTOMER.name())
					.antMatchers("/customer/loading").permitAll()

					.and()

					.formLogin()
					.loginPage("/customer/login")
					.defaultSuccessUrl("/customer/main")
					.permitAll()

					.and()

					.logout()
					.logoutSuccessUrl("/")
					.deleteCookies("JSESSIONID")
					.permitAll();
		}
	}

	@Configuration
	@Order(2)
	public static class DistributorSecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
					.antMatchers("/distributor/**").hasRole(RoleKind.DISTRIBUTOR.name())
					.antMatchers("/distributor/loading").permitAll()

					.and()

					.formLogin()
					.loginPage("/distributor/login")
					.defaultSuccessUrl("/distributor/main")
					.permitAll()

					.and()

					.logout()
					.logoutSuccessUrl("/")
					.deleteCookies("JSESSIONID")
					.permitAll();
		}
	}

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/", "/index", "/loading_c", "/loading_d").permitAll()
					.antMatchers("/css/**", "/js/**", "/font/**", "/img/**").permitAll()
					.anyRequest()
					.authenticated()
				.and()
					.formLogin().successHandler(authenticationSuccessHandler)
					.loginPage("/login")
					.failureUrl("/login?error=true")
				.permitAll()
				.and()
					.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.invalidateHttpSession(true)
					.logoutSuccessUrl("/index")
				.and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
					*//*.logoutSuccessHandler((request, response, authentication) -> {
						response.sendRedirect("/index");
					})*//*;
	}*/

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerCredentialsService).passwordEncoder(bCryptPasswordEncoder());
		auth.userDetailsService(distributorCredentialsService).passwordEncoder(bCryptPasswordEncoder());
	}
}
