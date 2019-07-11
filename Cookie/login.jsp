<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Cookie [] cookies = request.getCookies();
	String cid=null , cpw=null , cauto=null;
	for(Cookie c : cookies){
		
		String key = c.getName();
		if(key.equals("cookieId")){
			cid = c.getValue();
		}if(key.equals("cookiePw")){
			cpw = c.getValue();	
		}if(key.equals("cookieAuto")){
			cauto = c.getValue();
		}
	}
	if (cid != null && cpw != null && cauto != null){
		response.sendRedirect("cookiePro.jsp");
	}
	


%>


<form action="cookiePro.jsp" method="post">
	id: <input type="text" name="id" /> <br />
	pw: <input type="password" name="pw" /> <br />
	자도 로그인  : <input type = checkbox name="auto" value="1" /> <br />
			<input type ="submit" value="로그인" /> <br />

</form>
