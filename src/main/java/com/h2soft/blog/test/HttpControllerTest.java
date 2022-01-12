package com.h2soft.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//사용자 요청 >> 응답 Html (@Controller)
//사용자 요청 >> 응답 Data (@RestController)

@RestController
public class HttpControllerTest {
	
	//get @RequestParam int id
	//get Member m
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청 "+m.getId()+" "+m.getUsername()+" "+m.getPassword()+" "+m.getEmail();
	}
	
	//post @RequestBody String text (text/plan)
	//post @RequestBody Member m (application/json) //MessageConverter 스프링 부트가 처리함.
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {  
		return "post 요청 :"+m.getId()+" "+m.getUsername()+" "+m.getPassword()+" "+m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청"+m.getId()+" "+m.getUsername()+" "+m.getPassword()+" "+m.getEmail();
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
}
