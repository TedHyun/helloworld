<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <% request.setCharacterEncoding("euc-kr");%>

<%
    String id = request.getParameter("id");
	String passwd  = request.getParameter("passwd");
	
	LogonDBBean manager = LogonDBBean.getInstance();
    int check= manager.userCheck(id,passwd); --%>


	<c:if test="${check ==1}">
		<c:redirect url="main.do"/>
	</c:if>
	<c:if test="${check ==0}">
	<script> 
	  alert("��й�ȣ�� ���� �ʽ��ϴ�.");
      history.go(-1);
	</script>'
	</c:if>
	<c:if test="${check == -1}">
	<script>
	  alert("���̵� ���� �ʽ��ϴ�..");
	  history.go(-1);
	</script>
	</c:if>