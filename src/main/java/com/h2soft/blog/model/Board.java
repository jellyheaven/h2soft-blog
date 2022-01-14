package com.h2soft.blog.model;



import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {

	@Id ////Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; //시퀀스 auto_increment
	
	@Column(nullable = false, length =100)
	private String title;
	
	@Lob //대용량 
	private String content; //섬머노트 라이브러리 사용 html 태그 
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER) //Many = Board , User = One //EAGER 반드시 가져올게
	@JoinColumn(name = "userId")
	private User user; //DB는 오브젝트를 저장할 수 없다 FK 자바는 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy = "board" , fetch = FetchType.LAZY) //One Board , Many = Reply //mappedBy 연관관계가 아니라는 표현 FK가 아님.
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
