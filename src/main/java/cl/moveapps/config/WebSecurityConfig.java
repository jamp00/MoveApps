package cl.moveapps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cl.moveapps.security.JWTAuthorizationFilter;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("JwtAuthenticationEntryPoint")
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	JWTAuthorizationFilter jWTAuthorizationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.addFilterAfter( jWTAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/token/").permitAll()
			.anyRequest().authenticated().and()
			.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
