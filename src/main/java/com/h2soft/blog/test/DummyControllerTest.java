package com.h2soft.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2soft.blog.model.RoleType;
import com.h2soft.blog.model.User;
import com.h2soft.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired //의존성 주입(DI)
	private UserRepository userRepository;
	
	//Insert (회원가입)
	//파라미터 방식 @RequestParam("username") String username 생략 가능
	//http 의 body 에 데이터를 가지고 요청  자동 String username, String password, String email
	//User user 오브젝트로 가져올 수 있음.
	@PostMapping("/dummy/join")
	public String join(User user) {		
		//public String join(String username, String password, String email)
		//System.out.println("username : "+username);
		//System.out.println("password : "+password);
		//System.out.println("email : "+email);
		
		System.out.println("id : "+user.getId());
		System.out.println("username : "+user.getUsername());
		System.out.println("password : "+user.getPassword());
		System.out.println("email : "+user.getEmail());
		System.out.println("role : "+user.getRole());
		System.out.println("createDate : "+user.getCreateDate());
		
		user.setRole(RoleType.USER); //개발자 실수를 방지 하기 위해 Enum 처리 한다. 

		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
	
	//Select {id} 상세정보
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4 를 찾으면 내가 db에서 못찾아오면 user가 nll 될거 아냐?
		//그럼 return null이 리턴되자나 그럼 프로그램에 문제가 있지 않겠니
		//Optional 로 나의 User객체를 감싸서 가져올테니 null 인지 판단하여 return 해!
		//userRepository.findById(id).get() 널이 무조건 없을때
		
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				return new User();
//			}
//		});
		
		//tip 람다식 표현  
//		User user = userRepository.findById(id).orElseThrow(()->{
//			return new IllegalArgumentException("해당유저는 없습니다. id:"+id);
//		});
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당유저는 없습니다. id:"+id);
			}
		});
		
		//요청 : 웹 브라우저  
		//user 객체는 자바 오브젝트
		//변환 (웹브라우저가 이해할 수 잇는 데이타 json )
		//스프링 부트 = MessageConverter 라는 애가 응답시 자동 작동
		//자바 오브젝트를 리턴하게 되면 Jackson 라이브러리 호출해서 통해 자동으로 변환 처리 브라우저에 던져줌. 
		return user; 
	}
	
	//Select 전체 리스트
	@GetMapping("/dummy/users")
	public List<User> list(){		
		return userRepository.findAll();
	}
	
	//Page 한페이지당 2건에 데이타를 리턴 예정
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable  pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		//if(pagingUser.isFirst()) pagingUser.isLast  함수 통해 처리 할 수 있음.
		
		List<User> users= pagingUser.getContent();
		
		return users;
	}
	
	//Update email, password 수정 (더티체킹 이용)
	@Transactional //함수종료시 자동 commit 이됨.
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User reqUser) {
		//@RequestBody json 데이타를 요청 하여 Java Object로 변환해서 받아줘요 
		//MessageConverter 가 jackson 라이브러리 호출 요청 하여 받아줌.
		System.out.println("id : "+id);
		System.out.println("pass"+reqUser.getPassword());
		System.out.println(""+reqUser.getEmail());
		//reqUser.setId(id);
		//reqUser.setUsername("ssar11");		
		
		User user= userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다. id:"+id);
		});
		
		user.setPassword(reqUser.getPassword());
		user.setEmail(reqUser.getEmail());
		
		//@Transactional 선언하면 더티체킹됨.
		
		return user;
	}
	
	//Delete
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			return "삭제에 실패했습니다. 해당ID는 DB에 없습니다."+id;
		}
		
		return "삭제되었습니다."+id;
	}
}
