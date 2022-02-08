<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form>
		<input type="hidden" id="id" value="${board.id}" />
		<div class="form-group">		  
		  <input type="text" class="form-control" id="title" placeholder="사용자를 입력하세요." value="${board.title}"  >
		</div>    
		<div class="form-group">		  
		  <textarea class="form-control summernote"  id="content" rows="3" >${board.content}</textarea>
		</div>
	</form>
	<button id ="btn-update" class="btn btn-primary">글수정완료</button>
</div>

<script>
	$('.summernote').summernote({	  
	  tabsize: 2,
	  height: 300
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>

