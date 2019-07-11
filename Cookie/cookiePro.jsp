<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String auto = request.getParameter("auto");
	//db확인 
	Cookie [] cookies = request.getCookies();
for(Cookie c : cookies) {
	
	String key = c.getName();
	if(key.equals("cookieId")){
		id =c.getValue();
	}if(key.equals("cookiepw")){
		pw = c.getValue();	
	}if(key.equals("cookieAuto")){
		auto = c.getValue();
	}
}
	
	if(auto == null){
		session.setAttribute("loginId", id);
		
		
	}else{
		session.setAttribute("loginId", id);
		Cookie c1 = new Cookie("cookieId",id);
		Cookie c2 = new Cookie("cookiePw",pw);
		Cookie c3 = new Cookie("cookieAuto",auto);
		c1.setMaxAge(60*60*24);
		c2.setMaxAge(60*60*24);
		c1.setMaxAge(60*60*24);
		response.addCookie(c1);
		response.addCookie(c2);	
		response.addCookie(c3);	
	}
	
	
%>

<h2><%=id %> 님이 로그인 되었습니다.</h2>





<button>쿠키 확인</button>
<button onclick="window.location ='cookielogout.jsp'">로그 아웃</button>