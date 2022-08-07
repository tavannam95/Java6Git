package edu.poly.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.poly.service.UserSevice;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserSevice userSevice;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSevice);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();
		

		//Phân quyền sử dụng
		http.authorizeRequests()
//			.antMatchers("/home/admins").hasRole("ADMIN")
//			.antMatchers("/home/users").hasAnyRole("ADMIN","USER")
//			.antMatchers("/home/authenticated").authenticated()
//			.antMatchers("/home/index2","/auth/login/**").permitAll()
			.anyRequest().permitAll();//authenticated();
		
		http.oauth2Login()
			.loginPage("/auth/login/form")
			.defaultSuccessUrl("/oauth2/login/success", true)
			.failureUrl("/auth/login/error")
			.authorizationEndpoint()
				.baseUri("/oauth2/authorization");
		
		//Điều khiển lỗi vai trò
		http.exceptionHandling()
			.accessDeniedPage("/auth/access/dined");
		
		http.formLogin()
			.loginPage("/auth/login/form")
			.loginProcessingUrl("/auth/login")
			.defaultSuccessUrl("/auth/login/success",false)
			.failureUrl("/auth/login/error")
			.usernameParameter("username")
			.passwordParameter("password");
		
		http.rememberMe()
			.rememberMeParameter("remember");
		
		http.logout()
			.logoutUrl("/auth/logoff")
			.logoutSuccessUrl("/auth/login/form");
		
		
	}
}
