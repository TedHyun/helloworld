<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${c== 1}">
	<c:redirect url="main.do" />
</c:if>
<c:if test="${c != 1}">
	<script>
		alert("���̵� & ��й�ȣ�� Ȯ���ϼ���");
		history.go(-1);
	</script>
</c:if>

