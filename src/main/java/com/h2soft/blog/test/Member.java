package com.h2soft.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Getter  get메소드 자동생성
//@Setter  set메소드 자동생성
@Data  //get set  메소드 자동 생성
//@AllArgsConstructor //allargs 생성자 생성 
@NoArgsConstructor  //기본생성자 
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder //순서 상관없이 초기화 값 장점 
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}	
}
