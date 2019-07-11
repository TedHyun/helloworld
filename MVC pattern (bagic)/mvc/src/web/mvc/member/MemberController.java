package web.mvc.member;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.bean.SuperBean;

public class MemberController extends HttpServlet{

	private Map command = new HashMap();// properties 재정의한 값을 다시 넣어줌 ,pro
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("propertiesPath");//web.xml에 propertiesPath 를 매게변수로 넣음
		Properties p = null; 
		InputStream is = null; 
		try {
			is = new FileInputStream(path);
			p = new Properties();
			p.load(is);
			Iterator it = p.keySet().iterator();// properties 의 key 값만 꺼내서 Iterator 에 넣음
			while(it.hasNext()) {
				String key = (String)it.next(); //form.do 
				String value = p.getProperty(key); //FormBean
				Class c = Class.forName(value); // class 로드 시키는 작업
				Object obj = c.newInstance(); // New FormBean()
				command.put(key , obj);
			}
			System.out.println(p);
			System.out.println(command);
		}catch(Exception e) 
		{e.printStackTrace();}
		
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String uri = request.getRequestURI(); // /mvc/loginForm.do
		Object obj = command.get(uri); // LoginFormBean
		SuperBean sb = null;
		String view = "/member/main.jsp";//default 값
		if(obj instanceof SuperBean) {
			sb = (SuperBean)obj;
			view = sb.actionBean(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
		
		
		
		
		/* MVC 패턴 종류(2)
		 * String view =""; // 요청 URI 분석 : http://localhost:8080/mvc/loginPro.mem
		 * 
		 * 
		 * 
		 * String uri = request.getRequestURI();
		 * 
		 * System.out.print(uri); SuperBean sb = null;
		 * if(uri.equals("/mvc/loginForm.mem")) { sb = new LoginFormBean();
		 * 
		 * view=sb.actionBean(request, response); }else
		 * if(uri.equals("/mvc/loginPro.mem")) { sb = new LoginProBean();
		 * view=sb.actionBean(request, response); }
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher(view);
		 * rd.forward(request, response);
		 */
	}


}
