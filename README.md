# h2soft-blog

##스프링 부트 + JPA 로 블로그 개발 연습

[Controller 생성 및 실습]  
HttpControllerTest.java 생성  
Get 메서드  
Post 메서드  
Put 메서드  
Delete 메서드  
    
[lombok설치]  
@Getter  (get메소드 자동생성)  
@Setter  (set메소드 자동생성)  
@Data  (get set  메소드 자동 생성)  
@AllArgsConstructor (allargs 생성자 생성)  
@NoArgsConstructor  (기본생성자)  
@RequiredArgsConstructor (final)  
@Builder (순서 상관없이 초기화 값 장점)  
  
[yml 설정]  
  
[JPA 설명- hibernate] 

org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
엔티티를 만들 때 변수명 그대로 DB에 필드를 만들어 준다.
org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
엔티티를 만들 때 변수명에 언더스코어를 붙여준다. 예) createDate -> create_date

1. Blog 테이블 만들기 (User, Board, Reply)  
  
2. JPA 애노테이션 설명  
@Entity //User 클래스가 mariadb에 테이블 생성  
@Id //Primary key  
@GeneratedValue(strategy = GenerationType.IDENTITY)  //프로젝트에서 연결된  DB의 넘버링 전략을 따라간다.  //시퀀스, auto_increment   
@Column(nullable = false, length = 30)    
@ColumnDefault("'user'")    //기본값
@CreationTimestamp  //시간이 자동 입력

- 연관관계 -   
@ManyToOne  
@OneToMany  
@OneToMany(mappedBy = "board") //mappedBy 연관관계가 아니라는 표현 FK가 아님.  
@OneToOne  
@ManyToOne(fetch = FetchType.EAGER)  
EAGER 은 반드시 가져와야 함. LAZY 필요할때만 가져옴.  
  
3. 더미데이타 
Insert
Select 
Update
Delete

4. 화면 구현  
 - 메뉴와 푸터  
 - 회원가입 화면(Ajax 사용 테스트)  
 - 로그인 화면   
 - 회원 수정 화면  
 - 글 목록 화면(메인화면)  
 - 글 상세보기 화면  
 - 글 수정 화면  
