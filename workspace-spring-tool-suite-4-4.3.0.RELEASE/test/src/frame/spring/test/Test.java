package frame.spring.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frame.spring.vo.LoginDAO;
import frame.spring.vo.LoginVO;

@Controller
public class Test {
		ModelAndView mv = null;
	@RequestMapping("form.ds")
	public String form() {
		return "form.jsp";
	} 
	@RequestMapping("pro.ds")
	public ModelAndView pro(String id, String passwd) {
		LoginDAO ds = LoginDAO.getInstance();
		int x = ds.Logincheck(id, passwd);	
		mv = new ModelAndView();
		mv.addObject("id",x);
		mv.setViewName("pro.jsp");
		return mv;
	} 
}
