package com.h2soft.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //파일 반환 방식
public class TempControllerTest {

	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome");
		
		//파일리턴 기본경로 /src/main/resource/static
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String temImg() {
		return "/a.png";
	}
	
	@GetMapping("/temp/jsp")
	public String temJsp() {
		return "test";
	}
}
