package com.h2soft.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2soft.blog.model.RoleType;
import com.h2soft.blog.model.User;
import com.h2soft.blog.repository.UserRepository;

@Service //스프링이 컴포넌트 스캔을 통해서 Bean에 등록해줌. IOC 해줌.
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	//회원가입
	@Transactional
	public void userJoin(User user) {
		String rawPassword = user.getPassword(); //원문
		String encPassword = encoder.encode(rawPassword); //해쉬
		user.setPassword(encPassword);		
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
}

////로그인 //전통적인 로그인 방법
//@Transactional(readOnly = true) //select 할때 트랜잭션 시작 , 서비스 종료시 트랜잭션 종료 (정합성유지)
//public User userLoin(User user) {
//	return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//}