package com.gabrielpf.wodfeeder.configuration;

import com.gabrielpf.wodfeeder.auth.WodFeederUserDetailsService;
import com.gabrielpf.wodfeeder.model.auth.AuthGroupEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private WodFeederUserDetailsService service;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		var provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(13));
		provider.setAuthoritiesMapper(authoritiesMapper());
		return provider;
	}

	@Bean
	public GrantedAuthoritiesMapper authoritiesMapper() {
		var authorityMapper = new SimpleAuthorityMapper();

		authorityMapper.setConvertToUpperCase(true);
		authorityMapper.setDefaultAuthority(AuthGroupEnum.USER.getAuthGroup());

		return authorityMapper;
	}

	@Bean
	public CorsConfigurationSource configureCors() {
		var configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Collections.singletonList("*"));
		configuration.setAllowedOrigins(List.of("GET", "POST"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));

		final var source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.cors().configurationSource(configureCors())
				.and()
				.authorizeRequests()
				.antMatchers("/api/**", "/home")
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
//				.loginPage("/login")
				.loginProcessingUrl("/api/user/signin")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true);
	}
}
