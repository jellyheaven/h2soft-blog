<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@ include file="../layout/header.jsp" %>

<div class="container">
  <form action="/user/join" method="post">
    <div class="form-group">
      <label for="username">Username</label>
      <input type="text" class="form-control" id="username" placeholder="사용자를 입력하세요." name="username">
    </div>    
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" placeholder="패스워드를  입력하세요." name="password" autocomplete="off">
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요." name="email">
    </div>    
    
  </form>  
  <button type="button" id="btn-save" class="btn btn-primary">회원가입완료</button>  
</div>

<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp" %>