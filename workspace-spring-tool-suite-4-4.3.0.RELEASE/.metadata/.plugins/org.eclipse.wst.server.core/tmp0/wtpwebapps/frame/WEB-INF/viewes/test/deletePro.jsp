<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${c==1}">
	<script>
		alert("Ε»Επ");
	</script>
</c:if>
<c:if test="${c!=1}">
	<script>
		alert("ΊρΉψ Θ®ΐΞ");
		history.go(-1);
	</script>

</c:if>