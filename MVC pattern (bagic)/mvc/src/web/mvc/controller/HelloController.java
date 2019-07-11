package web.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// HttpServlet Ŭ���� ���
// doGet / do Post / service 3������ �Ѱ����� �������̵� �Ѵ�.

public class HelloController extends HttpServlet{
	

	public void init(ServletConfig config) throws ServletException {
	System.out.println("init0");
		
	}
	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * request.setAttribute("num", 7777); request.setAttribute("name", "hong");
		 * 
		 * HttpSession session = request.getSession(); session.setAttribute("memId",
		 * "java");
		 */
		
		System.out.println("service");
		
		RequestDispatcher rd = request.getRequestDispatcher("/0701/HelloJsp.jsp");
		rd.forward(request, response);
		
	}

	
	
}
