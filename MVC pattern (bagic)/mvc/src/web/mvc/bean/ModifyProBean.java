package web.mvc.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class ModifyProBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     request.setCharacterEncoding("euc-kr");
	     HttpSession session = request.getSession();
		try {
	    LogonDBBean manager = LogonDBBean.getInstance();
	    LogonDataBean member = new LogonDataBean();
		member.setPasswd(request.getParameter("passwd"));
		member.setEmail(request.getParameter("email"));
		member.setName(request.getParameter("name"));
		member.setBlog(request.getParameter("blog"));
		member.setId(request.getParameter("id"));
		
		String id = (String)session.getAttribute("memId");
		member.setId(id);

		manager.updateMember(member);
	    }catch(Exception e) {e.printStackTrace();}
	    return "/member/modifyPro.jsp";
	}

}