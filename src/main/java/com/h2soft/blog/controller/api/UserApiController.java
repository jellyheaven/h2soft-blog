package com.h2soft.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2soft.blog.dto.ResponseDto;
import com.h2soft.blog.model.RoleType;
import com.h2soft.blog.model.User;
import com.h2soft.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userservice;	
	
	//회원가입
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출");		
		userservice.userJoin(user);
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
