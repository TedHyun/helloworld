<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="UTF-8"/>
<%-- 
<fmt:formatDate value="${day}" type="date" /> <br />
<fmt:formatDate value="${day}" type="time" /> <br />
<fmt:formatDate value="${day}" type="both" /> <br />


<fmt:formatDate value="${day}" type="both" dateStyle="short" timeStyle="short"/> <br />
<fmt:formatDate value="${day}" type="both" dateStyle="medium"timeStyle="medium"/> <br />
<fmt:formatDate value="${day}" type="both" dateStyle="long" timeStyle="long"/> <br />
<fmt:formatDate value="${day}" type="both" dateStyle="full" timeStyle="full"/> <br /> --%>

<fmt:formatDate value="${day}" pattern="yyyy년mm월dd일"/> <br />

<fmt:formatNumber value="10000000" groupingUsed="true" /> <br />
<fmt:formatNumber value="10000000" groupingUsed="false" /> <br />

<fmt:formatNumber value="1500.25" type="currency" currencySymbol="\\" />  <br />
<fmt:formatNumber value="1500.25" type="currency" currencySymbol="$" />	  <br />
<fmt:formatNumber value="0.3" type="percent" />  <br />

<fmt:formatNumber value="1500.255" pattern=".0" /><br />

<fmt:timeZone value="GMT">
	GMT : <fmt:formatDate value="${day}" type="both" /> <br />
</fmt:timeZone>

<fmt:timeZone value="GMT-8">
	GMT-8 : <fmt:formatDate value="${day}" type="both" /> <br />
</fmt:timeZone>

<%-- 	<c:if test="${num > 100 }">
		<h1>100보다 크다</h1>	
	</c:if>
	<c:if test="${num < 100 }">
		<h1>100보다 작다</h1>	
	</c:if>
	<br />
	
	<c:forEach items="${list}" var="vo">	
	<h2>${vo.num} ${vo.writer}</h2>
	
	</c:forEach>
	
	<c:forEach begin="0" end="9" step="1" var="a">	
		${a}
	
	</c:forEach>
	
	<c:forEach begin="2" end="9" step="1" var="a">	

	<c:forEach begin="1" end="9" step="1" var="b">	
		${a}X${b}=${a*b}<br />
	</c:forEach>
	</c:forEach>
	<c:forTokens items="a,b,c,d,e,f,g" delims="," var="a">
		${a}
	</c:forTokens>
	
	<c:import url="/member/main.jsp" var="ma" />
	${ma} --%>
	<c:set var="a" value="100" />
	${a} <br />
	<c:choose>
		<c:when test="${a > 100 }">크다</c:when>
		<c:when test="${a < 100 }">작다</c:when>
		<c:otherwise>같다</c:otherwise>	
	</c:choose>
	<%-- 
	<c:url var="a" value="member/main.jsp">
	<c:param name="id" value="java"/>
	<c:param name="pw" value="1234"/>
	</c:url>
	
	<c:redirect url="${a}" />  --%>
	
	
	
	<%-- <h1>num = <%=request.getAttribute("num") %></h1>
	<h1>id = <%=request.getAttribute("id") %></h1>
	<h1>age = <%=(String)request.getAttribute("age")+10 %></h1>
	
	<br /> <br />
	
	<h1>num = ${num} </h1>
	<h1>id = ${id} </h1>
	<h1>data = ${data} </h1>
	<h1>age = ${age+num} </h1>
	<h1>age = ${age+'10'} </h1>
	<h1>num = ${sessionScope.num} </h1>
	<h1>memId = ${sessionScope.memId} </h1>
	<br/><br/>
	<h1>arr = ${arr[0]} </h1>
	<h1>list =${list.get(1)}</h1>
	<br /><br />
	<hr>
	<h1>vo = ${vo}</h1>
	<h1>vo = ${vo.id}</h1>
	<h1>vo = ${vo.age}</h1>
	<h1>vo = ${vo.name}</h1>
	 --%>