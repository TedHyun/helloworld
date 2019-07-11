<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();

	Cookie [] cookies = request.getCookies();
	for(Cookie c : cookies) {
		//out.println("key="+c.getName());
		//out.println("value="+c.getValue());
		//out.println("<p>");
		String key = c.getName();
		if(key.equals("cookieId")){
			c.setMaxAge(0);
			response.addCookie(c);
		}if(key.equals("cookiePw")){
			c.setMaxAge(0);
			response.addCookie(c);
		}if(key.equals("cookieAuto")){
			c.setMaxAge(0);
			response.addCookie(c);
		}
		
	}
%>
<script>
	alert("logout");
	window.location="cookieForm.jsp";
</script>