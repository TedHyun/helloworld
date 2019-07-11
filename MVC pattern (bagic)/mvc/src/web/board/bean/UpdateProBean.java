package web.board.bean;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class UpdateProBean implements SuperBBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 request.setCharacterEncoding("euc-kr");
		    String pageNum = request.getParameter("pageNum");
		    BoardDataBean article = null;
		    try {  
		    article = new BoardDataBean();
		 	article.setContent(request.getParameter("content"));
		 	article.setEmail(request.getParameter("email"));
		 	article.setNum(Integer.parseInt(request.getParameter("num")));
		 	article.setPasswd(request.getParameter("passwd"));
		 	article.setSubject(request.getParameter("subject"));
		 	article.setWriter(request.getParameter("writer"));
		 	article.setReg_date(new Timestamp(System.currentTimeMillis()) );

			BoardDBBean dbPro = BoardDBBean.getInstance();
		    int check = dbPro.updateArticle(article);
		    request.setAttribute("check", check);
		    request.setAttribute("pageNum", pageNum);
			}catch(Exception e) {e.printStackTrace();}
		 
		 
		return "/board/updaterPro.jsp";
	}
	
}
