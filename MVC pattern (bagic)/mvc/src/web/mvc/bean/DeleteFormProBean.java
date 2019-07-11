package web.mvc.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;

public class DeleteFormProBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		request.setCharacterEncoding("euc-kr");
		LogonDBBean manager = LogonDBBean.getInstance();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		String passwd  = request.getParameter("passwd");
		try {
			int check = manager.deleteMember(id,passwd);
			if(check == 1) {
			session.invalidate();
			}
		}
			
		catch(Exception e) {e.printStackTrace();}
		
		
		return "/member/deletePro.jsp";
	}
	
}
