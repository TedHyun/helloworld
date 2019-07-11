package web.mvc.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch11.logon.LogonDBBean;

public class ConfirmBean implements SuperBean{

		    @Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    	request.setCharacterEncoding("euc-kr");
		    	 try {
		    	String id = request.getParameter("id");
				LogonDBBean manager = LogonDBBean.getInstance();
					int check= manager.confirmId(id);
					request.setAttribute("check", check);
					request.setAttribute("id", id);
			    }catch(Exception e) {e.printStackTrace();}
		    	 	return "/member/confirmId.jsp";	    	
		    	}
		    }

		    