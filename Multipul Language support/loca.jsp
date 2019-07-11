<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.NumberFormat" %>
<h1>다국어 지원 기능 locale 클래스 활용</h1>
<%
	Locale locale = request.getLocale();
	Date day = new Date();
	DateFormat df = DateFormat.getDateInstance(DateFormat.FULL.locale);
	NumberFormat nf = NumberFormat.getNumberInstance(locale);
%>

<h2>국가(영문코드):<%=locale.getCountry() %></h2>
<h2>날짜 시간: <%=df.format(day)%></h2>
<h2>숫자 : <%=nf.format(123141151)%></h2>