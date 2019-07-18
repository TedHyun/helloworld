package frame.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frame.spring.vo.Bar;
import frame.spring.vo.Foo;
import frame.spring.vo.FormVO;

@Controller
public class HelloBean {
	
	@Autowired
	private Foo f = null;
	
	@Autowired
	private Bar b = null;
	
	@RequestMapping("hello.do")
	public String hello() {
		System.out.println(f);
		System.out.println(f.getBar());
		System.out.println(f.getDay());
		return"/0708/hello.jsp";
	}
	@RequestMapping("form.do")
	public String form() {
		System.out.println("hello form");
		return"/0708/form.jsp";
	}
	@RequestMapping("pro.do")
	public ModelAndView pro(FormVO vo) {
		System.out.println("----"+vo.getId());
		System.out.println(vo.getPw());
		ModelAndView mv = new ModelAndView();
		//request.setAttribute();
		mv.addObject("id",vo.getId());
		mv.setViewName("/0708/pro.jsp");
		return mv;
	}
}