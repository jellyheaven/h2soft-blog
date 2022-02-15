/**
 * 회원가입 
 */
 let index = {
 	init:function(){
		 $("#btn-save").on("click", ()=>{  //function(){} , ()=>{} this를 바인딩하기 위해서
			 this.save();
		 });
		 
		 $("#btn-update").on("click", ()=>{  //function(){} , ()=>{} this를 바인딩하기 위해서
			 this.update();
		 });
		 
		 //전통 로그인 방식 안씀
		 /*
			 $("#btn-login").on("click", ()=>{  //function(){} , ()=>{} this를 바인딩하기 위해서
				 this.login();
			 });
		 */
 	},

	save: function(){
		 //alert('테스트');

		 let data = {
			 username:$("#username").val(),
			 password:$("#password").val(),
			 email:$("#email").val()
		 };

		 //console.log(data);
		 //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청! 
		 //ajax 호출시 default 가 비동기 호출 
		 $.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data),	//http body데이타				
			contentType:"application/json;chartset=utf-8", //body 데이타가 어떤 타입인지 (MIME)
			dataType:"json" //요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면)			 
		 }).done(function(resp){
			alert("회원가입이 완료되었습니다.");
			//console.log(resp);
			location.href ="/";
		 }).fail(function(error){
			 alert(JSON.stringify(error));
		 }); 
	 }, //end save
	 
	 update: function(){

		 let data = {
		 	 id: $("#id").val(),
		 	 username:$("#username").val(),
			 password:$("#password").val(),
			 email:$("#email").val()
		 };
		 
		 console.log(data);
		 
		 $.ajax({
			type:"PUT",
			url:"/user",
			data:JSON.stringify(data),	//http body데이타				
			contentType:"application/json;chartset=utf-8", //body 데이타가 어떤 타입인지 (MIME)
			dataType:"json" //요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면)			 
		 }).done(function(resp){
			alert("회원수정이 완료되었습니다.");
			//console.log(resp);
			location.href ="/";
		 }).fail(function(error){
			 alert(JSON.stringify(error));
		 }); 
	 }, //end update
	 
	 /*
	 //전통 로그인 방식  안씀 참고용
	 login: function(){
		 //alert('테스트');

		 let data = {
			 username:$("#username").val(),
			 password:$("#password").val(),
			 email:$("#email").val()
		 };

		 //console.log(data);
		 //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청! 
		 //ajax 호출시 default 가 비동기 호출 
		 $.ajax({
			type:"POST",
			url:"/api/user/login",
			data:JSON.stringify(data),	//http body데이타				
			contentType:"application/json;chartset=utf-8", //body 데이타가 어떤 타입인지 (MIME)
			dataType:"json" //요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) >> javascript 
		 }).done(function(resp){
			alert("로그인이 완료되었습니다.");
			//console.log(resp);
			location.href ="/";
		 }).fail(function(error){
			 alert(JSON.stringify(error));
		 }); 
	 }
	 */
 } //index

 index.init();
 