<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<h1>JDBC Oracle DataBase Connection</h1>

<%
	//드라이버 로딩
	//JSP - JDBC 현재동작중
	// DriverManager 클래스에 자동 등록
	Class.forName("oracle.jdbc.driver.OracleDriver");

	String user = "class09" , pass="class09";
	String url ="jdbc:oracle:thin:@nullmaster.iptime.org:1521:xe";
	//DB 연결
	Connection conn = DriverManager.getConnection(url,user,pass);	

	//Query 작성
	String sql= "select * from test";
	PreparedStatement pstmt = conn.prepareStatement(sql);	
	ResultSet rs = pstmt.executeQuery();  //select 문 실행시 사용
	//pstmt.executeUpdate();	// 그외 나머지 사용
	
	while(rs.next()){ // next 역활 = 추출하고 한단계 내림.
		String name = rs.getString("define");
		int age = rs.getInt("age");
		out.println("<h2>"+name+" : "+age+"</h2>");
	}
	rs.close();//무조건 다끈어 줘야함.2티어방식 1티어방식
	pstmt.close();
	conn.close();
	

%>


	<h2>conn : <%=conn %></h2>
<%conn.close(); %>