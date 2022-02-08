<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form >
		<div class="form-group">		  
		  <input type="text" class="form-control" id="title" placeholder="사용자를 입력하세요."  >
		</div>    
		<div class="form-group">
		  
		  <textarea class="form-control summernote"  id="content" rows="3"></textarea>
		</div>
	</form>
	<button id ="btn-save" class="btn btn-primary">글쓰기완료</button>
</div>

<script>
	$('.summernote').summernote({	  
	  tabsize: 2,
	  height: 300
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>

