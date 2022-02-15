<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@ include file="../layout/header.jsp" %>

<div class="container">
  <form>
  	<input type ="hidden" id = "id" value="${principal.user.id}" >
    <div class="form-group">
      <label for="username">Username</label>
      <input type="text" class="form-control" id="username" placeholder="사용자를 입력하세요."  readonly="readonly"  value="${principal.user.username}">
    </div>    
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" placeholder="패스워드를  입력하세요."  autocomplete="off">
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요." value="${principal.user.email}" >
    </div>
  </form>  
  <button type="button" id="btn-update" class="btn btn-primary">회원수정완료</button>  
</div>

<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp" %>