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
		
		System.out.println("user>>"+user);
		userRepository.save(user);
	}
	
	//회원정보 수정
	@Transactional
	public void userInfoUpdate(User user) {
		//수정시에는 JPA 영속성 컨텍스트 User 오브젝트를 영속화 시키고 영속화된 User 오브젝트를 수정
		//Select를 해서 User 오브젝트를 DB로 부터 가져오는 이유는 영속화를 하기 위해서!
		//영속화된 오브젝트를 변경하면 자동으로 DB에 update 를 날려줌.		
		User persistance = userRepository.findById(user.getId())
					.orElseThrow(()->{
						return new IllegalArgumentException("회원찾기 실패 : 아이디를 찾을 수 없습니다.");
					});
		
		String rawPassword = user.getPassword(); //원문
		String encPassword = encoder.encode(rawPassword); //해쉬		
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());		
		//회원수정 함수 종료시 == 서비스 종료 == 트랜잭션 종료 == commit 자동 
		//영속성화된 perisitance 객체의 변화가 감지되면 더티체킹이 되어 update 문을 날려줌.
	}
}

////로그인 //전통적인 로그인 방법
//@Transactional(readOnly = true) //select 할때 트랜잭션 시작 , 서비스 종료시 트랜잭션 종료 (정합성유지)
//public User userLoin(User user) {
//	return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//}