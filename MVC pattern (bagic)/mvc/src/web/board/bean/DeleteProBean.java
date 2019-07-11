package web.board.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;

public class DeleteProBean implements SuperBBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("euc-kr");

		  int num = Integer.parseInt(request.getParameter("num"));
		  String pageNum = request.getParameter("pageNum");
		  String passwd = request.getParameter("passwd");
		  try {
		  BoardDBBean dbPro = BoardDBBean.getInstance();
		  int check = dbPro.deleteArticle(num, passwd);
		  request.setAttribute("check",check);
		  }catch(Exception e) {e.printStackTrace();}
		 request.setAttribute("pageNum",pageNum);
		 request.setAttribute("num", num);
		return "/board/deletePro.jsp";
	}

}
