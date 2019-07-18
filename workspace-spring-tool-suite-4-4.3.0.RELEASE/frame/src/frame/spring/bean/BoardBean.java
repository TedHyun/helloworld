package frame.spring.bean;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import frame.spring.dao.BoardDBBean;
import frame.spring.dao.BoardDataBean;

@Controller
@RequestMapping("/board/")
public class BoardBean {
	
	@Autowired
	private BoardDBBean dbPro= null;
	
	@Autowired
	private BoardDataBean article= null;
	
	@RequestMapping("list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
        int pageSize = 6;
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
          String pageNum = request.getParameter("pageNum");
          if (pageNum == null) {
                pageNum = "1";
                }
         	int currentPage = Integer.parseInt(pageNum);
            int startRow = (currentPage - 1) * pageSize + 1;
            int endRow = currentPage * pageSize;
            int count = 0;
            int number=0;
            int wid=0; 
            List articleList = null;
            try {
            	 request.setCharacterEncoding("euc-kr");
            	count = dbPro.getArticleCount();
               int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
               int startPage = (int)(currentPage/10)*10+1;
               int pageBlock=10;
               int endPage = startPage + pageBlock-1;
               if (endPage > pageCount) {endPage = pageCount;} 
               if (count > 0) {
                   articleList = dbPro.getArticles(startRow, endRow);
               }
               number=count-(currentPage-1)*pageSize;
               request.setAttribute("pageSize", pageSize);
               request.setAttribute("count",count);
               request.setAttribute("articleList", articleList);
               request.setAttribute("number", number);
               request.setAttribute("currentPage", currentPage);
               request.setAttribute("pageCount",pageCount );
               request.setAttribute("startPage",startPage );
               request.setAttribute("pageBlock", pageBlock);
               request.setAttribute("endPage", endPage);
               request.setAttribute("pageNum",pageNum);
               request.setAttribute("article", article);
               request.setAttribute("sdf", sdf);
               System.out.println(count);
            }catch (Exception e) {
              // TODO: handle exception
           }
      
     return "/board/list";
  }
	@RequestMapping("content.do")
	public String content() {
	
		return "/board/content";
	}@RequestMapping("deleteForm.do")
	public String deleteForm() {
	
		return "/board/deleteForm";
	}@RequestMapping("deletePro.do")
	public String deletePro() {
	
		return "/board/deletePro";
	}@RequestMapping("updateForm.do")
	public String inputForm() {
	
		return "/board/updateForm";
	}@RequestMapping("updatePro.do")
	public String updatePro() {
	
		return "/board/updatePro";
	}@RequestMapping("writerForm.do")
	public String writerForm() {
	
		return "/board/writerForm";
	}@RequestMapping("writerPro.do")
	public String writerPro() {
	
		return "/board/writerPro";
	}
	
}
