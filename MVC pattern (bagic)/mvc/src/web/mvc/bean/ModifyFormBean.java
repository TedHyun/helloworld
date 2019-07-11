package web.mvc.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class ModifyFormBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    request.setCharacterEncoding("euc-kr");
		try {
	    HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
	  
	    LogonDBBean manager = LogonDBBean.getInstance();
	    LogonDataBean c = manager.getMember(id);
	    request.setAttribute("c", c);
		}catch(Exception e) {e.printStackTrace();}
		
		
		return "/member/modifyForm.jsp";
	}

}