package test.ex.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class PageFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub 최조 실행시 한번동작 
		System.out.println("Filter init..!");
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = null;
		if(arg0 instanceof HttpServletRequest) {
			request = (HttpServletRequest)arg0;
			System.out.println(request.getRequestURI());
		}
		
		
		
		// TODO Auto-generated method stub 페이지가 실행될때 마다 동작
		System.out.println("Filter doFilter....before..!");
		
		arg2.doFilter(arg0,arg1);//다음 흐름으로 넘어감
		
		System.out.println("Filter doFilter....after..!");
		//System.out.println("Parameter"+arg0.getParameter("msg"));
	
		//arg2.doFilter(arg0,arg1);//다음 흐름으로 넘어감
		request.getRequestDispatcher("/0502/test.jsp").forward(request, arg1);
		
	}

		
	@Override
	public void destroy() {
		// TODO Auto-generated method stub 종료시 동작
		System.out.println("Filter destory..!");
	}

	
	
}
