package web.mvc.bean;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class InputFormProBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		try {
		LogonDataBean member = new LogonDataBean();
		member.setId(request.getParameter("id"));
		member.setBlog(request.getParameter("blog"));
		member.setEmail(request.getParameter("email"));
		member.setJumin1(request.getParameter("jumin1"));
		member.setJumin2(request.getParameter("jumin2"));
		member.setPasswd(request.getParameter("passwd"));
		member.setName(request.getParameter("name"));
		member.setReg_date(new Timestamp(System.currentTimeMillis()) );
		  LogonDBBean manager = LogonDBBean.getInstance();
			manager.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/member/inputPro.jsp";
	}

}
