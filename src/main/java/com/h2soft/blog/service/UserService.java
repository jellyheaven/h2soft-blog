package com.h2soft.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.h2soft.blog.model.User;
import com.h2soft.blog.repository.UserRepository;

@Service //스프링이 컴포넌트 스캔을 통해서 Bean에 등록해줌. IOC 해줌.
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public Integer userJoin(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return -1;
	}
}
