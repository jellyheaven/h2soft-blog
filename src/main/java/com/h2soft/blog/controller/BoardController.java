package com.h2soft.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.h2soft.blog.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//public String index(@AuthenticationPrincipal PrincipalDetail principal) { //컨트롤러에서 세션을 어떻게 찾나?
	@GetMapping(value = {"","/"})
	public String index(Model model,@PageableDefault(size=3, sort="id",direction= Sort.Direction.DESC  ) Pageable pageable) { //컨트롤러에서 세션을 어떻게 찾나?
		model.addAttribute("boards",boardService.boardAllRead(pageable));		
		return "index";
	}	
	
	//User 권한이 필요
	@GetMapping(value = "/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	@GetMapping(value = "/board/{id}")
	public String findByid(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		return "board/detail";
	}
	
	@GetMapping(value = "/board/{id}/updateForm")
	public String updateForm(@PathVariable int id , Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		return "board/updateForm";
	}
	
}
