<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<h1> 업로드 완료!! </h1>

<%-- <c:forEach begin="0"  end = "${list.size()-1 }" step="1" var="i">
<c:set var ="a" value="${list[i]}"/>
<img src="/frame/imgs/${a.newname}" width="400" />
<h1>${a.writer}</h1>
</c:forEach> --%>

<c:forEach items="${list}" var="vo">
	${vo.writer}
<img src="/frame/imgs/${vo.newname}" width="400" />	
	<button onclick="window.location='download.do?newname=${vo.newname}'">다운로드</button>
	<button onclick="window.location='delete.do?newname=${vo.newname}'">삭제</button>
</c:forEach>