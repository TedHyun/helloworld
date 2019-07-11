<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
		<h1>hello MVC view..!</h1>
		
		<h1><%= request.getAttribute("num")%></h1>
		<h1><%= request.getAttribute("name")%></h1>
		
		<h1><%= session.getAttribute("memId") %></h1>