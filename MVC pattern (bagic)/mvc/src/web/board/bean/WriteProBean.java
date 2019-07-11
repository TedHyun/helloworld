package web.board.bean;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class WriteProBean implements SuperBBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("euc-kr");
		 int num = Integer.parseInt(request.getParameter("num"));
		 BoardDataBean article = null;
		 try {    
		    article = new BoardDataBean();
		    
		 	article.setContent(request.getParameter("content"));
		 	article.setEmail(request.getParameter("email"));
		 	article.setNum(Integer.parseInt(request.getParameter("num")));
		 	article.setPasswd(request.getParameter("passwd"));
		 	article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		 	article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		 	article.setReadcount(Integer.parseInt(request.getParameter("readcount")));
		 	article.setRef(Integer.parseInt(request.getParameter("ref")));
		 	article.setSubject(request.getParameter("subject"));
		 	article.setWriter(request.getParameter("writer"));
		 	
		 	article.setReg_date(new Timestamp(System.currentTimeMillis()) );
			article.setIp(request.getRemoteAddr());

		    BoardDBBean dbPro = BoardDBBean.getInstance();
		    dbPro.insertArticle(article);
		    request.setAttribute("article", article);
		    request.setAttribute("num", num);
		 }
		 catch(Exception e) {e.printStackTrace();}
		
		return "/board/writePro.jsp";
	}

}
