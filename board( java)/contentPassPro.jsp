<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "board.BoardDBBean" %>
<%@ page import = "java.sql.Timestamp" %>

<% request.setCharacterEncoding("euc-kr");%>

<%
  int num = Integer.parseInt(request.getParameter("num"));
  String pageNum = request.getParameter("pageNum");
  String passwd = request.getParameter("passwd");

  BoardDBBean dbPro = BoardDBBean.getInstance();
  int check = dbPro.contentPass(num, passwd);

  if(check==1){%>
  <script>
  		window.location="contect.jsp?num=<%=num%>&pageNum=<%=pageNum%>";
  </script>
<% }else{%>
       <script language="JavaScript">            
         alert("��й�ȣ�� ���� �ʽ��ϴ�");
         history.go(-1);
      </script>
<%
    }
 %>