<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>  
      
<%@ include file="../layout/header.jsp" %>

<div class="container">
  <form action="/auth/joinProc" method="post">
    <div class="form-group">
      <label for="username">Username</label>
      <input type="text" class="form-control" id="username" placeholder="사용자를 입력하세요." name="username" >
    </div>    
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" placeholder="패스워드를  입력하세요." autocomplete="off" name="password">
    </div>    
    <button id ="btn-login" class="btn btn-primary">로그인</button> 
  </form>
   
  
  </div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>