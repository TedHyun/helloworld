<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color2.jsp"%>
<html>
<head>
<title>�Խ���</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>


<body bgcolor="${bodyback_c}">  
<center><b>�۳��� ����</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0"  bgcolor="${bodyback_c}" align="center">  
  <tr height="30">
    <td align="center" width="125" bgcolor="${value_c}">�۹�ȣ</td>
    <td align="center" width="125" align="center">
	     ${article.num}</td>
    <td align="center" width="125" bgcolor="${value_c}">��ȸ��</td>
    <td align="center" width="125" align="center">
	     ${article.readcount}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" bgcolor="${value_c}">�ۼ���</td>
    <td align="center" width="125" align="center">
	     ${article.writer}</td>
    <td align="center" width="125" bgcolor="${value_c}" >�ۼ���</td>
    <td align="center" width="125" align="center">
	     ${ sdf.format(article.reg_date)}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" bgcolor="${value_c}">������</td>
    <td align="center" width="375" align="center" colspan="3">
	     ${article.subject}</td>
  </tr>
  <tr>
    <td align="center" width="125" bgcolor="${value_c}">�۳���</td>
    <td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
  </tr>
  <tr height="30">      
    <td colspan="4" bgcolor="${value_c}" align="right" > 
	  <input type="button" value="�ۼ���" 
       onclick="document.location.href='updateForm.dt?num=${article.num}&pageNum=${pageNum}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
	  <input type="button" value="�ۻ���" 
       onclick="document.location.href='deleteForm.dt?num=${article.num}&pageNum=${pageNum}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" value="��۾���" 
       onclick="document.location.href='writeForm.dt?num=${num}&ref=${ref}&re_step=${re_step}&re_level=${re_level}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="button" value="�۸�� " 
       onclick="document.location.href='list.dt?pageNum=${pageNum}'">
    </td>
  </tr>
</table>    
</form>      
</body>
</html>      
