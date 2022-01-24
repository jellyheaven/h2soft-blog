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
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출");
		user.setRole(RoleType.USER);
		int result = userservice.userJoin(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),result);
	}
}
