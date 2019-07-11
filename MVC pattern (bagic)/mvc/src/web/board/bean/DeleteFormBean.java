package web.board.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormBean implements SuperBBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  int num = Integer.parseInt(request.getParameter("num"));
		  String pageNum = request.getParameter("pageNum");
		  request.setAttribute("num", num);
		  request.setAttribute("pageNum", pageNum);
		return "/board/deleteForm.jsp";
	}

}
