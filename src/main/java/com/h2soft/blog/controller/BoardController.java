package com.h2soft.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {
	
	//public String index(@AuthenticationPrincipal PrincipalDetail principal) { //컨트롤러에서 세션을 어떻게 찾나?
	@GetMapping(value = {"","/"})
	public String index() { //컨트롤러에서 세션을 어떻게 찾나?		
		return "index";
	}
}
