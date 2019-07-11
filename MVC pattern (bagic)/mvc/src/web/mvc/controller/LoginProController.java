package web.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProController extends HttpServlet{


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// MemberDAO dao = MemberDAO.getInstance();
		// int result = dao.userCheck(id,pw); 1 or 0 <- logic
		int result = 1;
		request.setAttribute("request",result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/0701/LoginPro.jsp");
		rd.forward(request, response);
	}
	
	
}
