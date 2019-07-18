<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color2.jsp"%>
<html>
<head>
<title>�Խ���</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="${bodyback_c}">
<center><b>�۸��(��ü ��:${count})</b>
<table width="700">
<tr>
    <td align="right" bgcolor="${value_c}">
    <a href="writeForm.dt">�۾���</a>
    </td>
</table>


<c:choose>
<c:when test="${count == 0 }">
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
    <td align="center">
    �Խ��ǿ� ����� ���� �����ϴ�.
    </td>
</table>
</c:when>
<c:otherwise>
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}"> 
      <td align="center"  width="50"  >�� ȣ</td> 
      <td align="center"  width="250" >��   ��</td> 
      <td align="center"  width="100" >�ۼ���</td>
      <td align="center"  width="150" >�ۼ���</td> 
      <td align="center"  width="50" >�� ȸ</td> 
      <td align="center"  width="100" >IP</td>    
    </tr>
   <c:forEach items="${articleList}" var="article">
   <c:if test="${number >0 }">
   <tr height="30">
    <td align="center"  width="50" > ${number} <c:set var="number" value="${number-1 }"/> </td>
    <td  width="250" >
    <c:choose>
    <c:when test="${article.re_level >0 }">
       <c:set var="wid" value="${10*article.re_level }"/>
     <img src="/mvc/board/images/level.gif" width="${wid }" height="16">
     <img src="/mvc/board/images/re.gif">
   </c:when>
   <c:otherwise>
   <c:set var="wid" value="${article.re_level }"/>
     <img src="/mvc/board/images/level.gif" width="${wid }" height="16">
   </c:otherwise>
   </c:choose>
      <a href="content.dt?num=${article.num }&pageNum=${currentPage}">
          ${article.subject}</a> 
          <c:if test="${article.readcount >= 20 }">
         <img src="/mvc/board/images/hot.gif" border="0"  height="16">
         </c:if> </td>
    <td align="center"  width="100"> 
       <a href="mailto:${article.email }">${article.writer }</a></td>
    <td align="center"  width="150">${sdf.format(article.reg_date) }</td>
    <td align="center"  width="50">${article.readcount }</td>
    <td align="center" width="100" >${article.ip }</td>
  </tr>
   </c:if>
     </c:forEach>
</table>
</c:otherwise>
</c:choose>

<c:if test="${count> 0 }">
   <c:if test="${startPage>10}">
       <a href="list.dt?pageNum=${startPage - 10 }">[����]</a>
   </c:if>
   <c:forEach begin="${startPage}"  end="${endPage}" step="1" var="i">
   
      <a href="list.dt?pageNum=${i}">[${i}]</a>
   </c:forEach>
   <c:if test="${endPage < pageCount }">
       <a href="list.dt?pageNum=${startPage + 10  }">[����]</a>
   </c:if>
</c:if>

</center>
</body>
</html>