package web.board.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class UpdateFormBean implements SuperBBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		  int num = Integer.parseInt(request.getParameter("num"));
		  String pageNum = request.getParameter("pageNum");
		  try{
		      BoardDBBean dbPro = BoardDBBean.getInstance();
		      BoardDataBean article =  dbPro.updateGetArticle(num);
		      request.setAttribute("article", article);
		  }catch(Exception e) {e.printStackTrace();}
		  request.setAttribute("pageNum", pageNum);
		return "/board/updateForm.jsp";
	}

}
