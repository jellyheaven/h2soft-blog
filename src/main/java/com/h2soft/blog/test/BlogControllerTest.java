package com.h2soft.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//특정 어노테이션이 붙어 있는 클래스를 new (IOC 스프링 컨테이너 관리)
//@Controller
@RestController
public class BlogControllerTest {
	
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello Spring boot </h1>";
	}
}
