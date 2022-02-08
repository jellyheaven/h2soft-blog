package com.h2soft.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reply {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id; //시퀀스 auto_increment
	
	@Column(nullable = false , length = 200)
	private String content;
	
	@ManyToOne //Many Reply, Board one
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne //Many Reply User oner
	@JoinColumn(name = "userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
