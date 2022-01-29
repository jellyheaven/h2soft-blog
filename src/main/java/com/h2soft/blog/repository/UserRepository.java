package com.h2soft.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.h2soft.blog.model.User;

//JPA DAO 
// 자동 빈으로 등록 됨.
//@Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {
	//Select * from user where username =1?;
	Optional<User> findByUsername(String username);
}

//JPA Nameing 전략
//select * from user where username=? AND password = ?
//User findByUsernameAndPassword(String username, String password);
	
//	@Query(value = "select * from user where username= ? AND password = ?", nativeQuery = true)
//	User login(String username, String password);