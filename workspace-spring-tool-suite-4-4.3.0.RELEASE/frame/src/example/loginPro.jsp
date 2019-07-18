<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${c== 1}">
	<c:redirect url="main.do" />
</c:if>
<c:if test="${c != 1}">
	<script>
		alert("아이디 & 비밀번호를 확인하세요");
		history.go(-1);
	</script>
</c:if>

