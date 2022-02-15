package com.h2soft.blog.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.h2soft.blog.config.auth.PrincipalDetailService;

//빈등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는것
//3가지가 시큐리티시 세트임.
@Configuration //빈등록 (ioc관리)
@EnableWebSecurity //스프링 시큐리티 필터로 등록함.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정주소로 접근하면 권한 및 인증을 체크!!
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	//메모리에 등록 위해 빈 처리
	@Override
	@Bean	
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	//암호화 처리 Ioc됨.
	@Bean
	public BCryptPasswordEncoder encodePwd() {		
		return new BCryptPasswordEncoder();
	}	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		
		http
			.csrf().disable()  //csrf 토큰 비활성화 (테스트시 걸어둠)
			.authorizeRequests()			
			.antMatchers("/","/auth/**","/js/**","/css/**","/image/**") 
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/loginForm") //인증페이지로 이동
			.loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 로그인 가로챈다. 
			.defaultSuccessUrl("/"); //실패시 이동 페이지 .failureUrl(authenticationFailureUrl) 
	}
	
	//시큐리티가 대시 로그앤해주는데 password를 가로채기하는데
	//해당 password가 뭘로 해쉬가 되어 회원가입이 되는지 알아야 
	//같은 해쉬로 암호화해서 db에 잇는 해쉬랑 비교할 수 있음.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePwd());
	}
}
