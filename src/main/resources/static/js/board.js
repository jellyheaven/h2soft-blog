/**
 * 글쓰기 
 */
 let index = {
 	init:function(){
		 $("#btn-save").on("click", ()=>{  //function(){} , ()=>{} this를 바인딩하기 위해서
			 this.save();
		 });
		 
		 $("#btn-delete").on("click", ()=>{  //function(){} , ()=>{} this를 바인딩하기 위해서
			 this.deleteById();
		 });
		 
		 $("#btn-update").on("click", ()=>{  //function(){} , ()=>{} this를 바인딩하기 위해서
			 this.update();
		 });
 	},

	save: function(){
		 let data = {
			 title:$("#title").val(),
			 content:$("#content").val()
		 };
		 
		 $.ajax({
			type:"POST",
			url:"/api/board",
			data:JSON.stringify(data),	//http body데이타				
			contentType:"application/json;chartset=utf-8", //body 데이타가 어떤 타입인지 (MIME)
			dataType:"json" //요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) >> javascript 
		 }).done(function(resp){
			alert("글쓰기가 완료되었습니다.");
			//console.log(resp);
			location.href ="/";
		 }).fail(function(error){
			 alert(JSON.stringify(error));
		 }); 
	 }, //end save
	 
	 deleteById : function(){
	 	let id = $("#id").text();		 
		 
		 $.ajax({
			type:"DELETE",
			url:"/api/board/"+id,
			dataType:"json" //요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) >> javascript 
		 }).done(function(resp){
			alert("삭제가 완료되었습니다.");
			//console.log(resp);
			location.href ="/";
		 }).fail(function(error){
			 alert(JSON.stringify(error));
		 }); 
	 }, //end deleteById
	 
	 update: function(){
	 	 let id = $("#id").val();
	 	 
		 let data = {		 		
			 title:$("#title").val(),
			 content:$("#content").val()
		 };		 
		 
		 $.ajax({
			type:"PUT",
			url:"/api/board/"+id,
			data:JSON.stringify(data),	//http body데이타				
			contentType:"application/json;chartset=utf-8", //body 데이타가 어떤 타입인지 (MIME)
			dataType:"json" //요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) 
		 }).done(function(resp){
			alert("글수정이 완료되었습니다.");
			//console.log(resp);
			location.href ="/";
		 }).fail(function(error){
			 alert(JSON.stringify(error));
		 });
		  
	 } //end update		 
	
 } //index

 index.init();
 