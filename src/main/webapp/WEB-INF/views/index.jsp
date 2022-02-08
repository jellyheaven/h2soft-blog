<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="layout/header.jsp" %>

<div class="container">
	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2" style="">    
		    <div class="card-body">
		      <h4 class="card-title">${board.title}</h4>      
		      <a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
		    </div>
  		</div>
	</c:forEach>
	<ul class="pagination justify-content-center">
	  
	  <c:choose>
	  	<c:when test="${boards.first}">
	  		<li class="page-item disabled"><a class="page-link" href="page=${boards.number-1}">Previous</a></li>		
	  	</c:when>	  	
	  	<c:otherwise>
	  		<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
	  	</c:otherwise>
	  </c:choose>	
	  <c:forEach var="i"  begin="1" end="${boards.totalPages}">
	  	<li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
	  </c:forEach>
	  <c:choose>
	  	<c:when test="${boards.last}">
	  		<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>		
	  	</c:when>	  	
	  	<c:otherwise>
	  		<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
	  	</c:otherwise>
	  </c:choose>
	  
	</ul>
</div>

<%@ include file="layout/footer.jsp" %>
<!-- <html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Summernote with Bootstrap 4</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
  </head>
  <body>
    <div id="summernote"></div>
    <script>
      $('#summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 100
      });
    </script>
  </body>
</html> -->