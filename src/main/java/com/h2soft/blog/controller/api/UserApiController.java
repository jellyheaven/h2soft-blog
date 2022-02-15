package com.h2soft.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2soft.blog.dto.ResponseDto;
import com.h2soft.blog.model.User;
import com.h2soft.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//회원가입
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출"+user);		
		userservice.userJoin(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){
		userservice.userInfoUpdate(user);
		
		//여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됬음.
		//하지만 세션값은 변경되지 않은 상태이기 때문에 우리가 직접 세션값을 변경해줌.
		
		//강제로 세션 변경하는 거임.
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));				
		SecurityContextHolder.getContext().setAuthentication(authentication);		
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}


//로그인 //전통적인 로그인 방법
//@Autowired HttpSession session DI해서 할 수 있음.
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		System.out.println("UserApicontroller : login 호출됨");
//		User principal = userservice.userLoin(user); //principal (접근 추제)
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
