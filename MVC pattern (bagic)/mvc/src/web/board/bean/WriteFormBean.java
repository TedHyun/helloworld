package web.board.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormBean implements SuperBBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  int num=0,ref=1,re_step=0,re_level=0;
		  try{  
		    if(request.getParameter("num")!=null){
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			re_level=Integer.parseInt(request.getParameter("re_level"));
			}
		   request.setAttribute("num", num);
		   request.setAttribute("re_step", re_step);
		   request.setAttribute("re_level", re_level);
		   request.setAttribute("ref", ref);
		  }
		    catch(Exception e) {e.printStackTrace();}
		return "/board/writeForm.jsp";
	}
	
}
