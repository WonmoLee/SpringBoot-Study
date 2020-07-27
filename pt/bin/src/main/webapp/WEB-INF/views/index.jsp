<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="layout/header.jsp" %>

<h1>index 페이지입니다.</h1>

<div class="container">
  <h2>게시판 렛츠기릿</h2>
  <table class="table">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="post" items="${posts}">
    	<tr>
    		<td>${post.id}</td>
    		<td><a href="/post/${post.id}">${post.title}</a></td>
    		<td><fmt:formatDate value="${post.createDate}" pattern="yyyy-MM-dd"/></td>
    	</tr>
    </c:forEach>
    </tbody>
  </table>
</div>


<%@ include file="layout/footer.jsp"%>