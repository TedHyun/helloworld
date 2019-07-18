package example;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import frame.spring.vo.TestVO;

@Controller
@RequestMapping("/test/")
public class TestBean {

	@Autowired
	private SqlSessionTemplate sql = null;
	
	@RequestMapping("form.do")
	public String form() {
		return "/test/form";
	}
	
	@RequestMapping(value="formPro.do" , method=RequestMethod.POST)
	public String formPro(MultipartHttpServletRequest request,String id,String pw,int age , String name) {
		MultipartFile mf = request.getFile("img");
		String path = request.getRealPath("imgs");
		String org = mf.getOriginalFilename();
		String ext = org.substring(org.lastIndexOf("."));
		String img = id+ext;
		File f = new File(path+"//"+img);
		try {
			mf.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		TestVO vo = new TestVO();
		vo.setAge(age);
		vo.setId(id);
		vo.setImg(img);
		vo.setPw(pw);
		vo.setName(name);
		// Mybatis insert ½ÇÇà 
		sql.insert("test.insertTest" , vo);
		
		return "/test/formPro";
	}
	
	@RequestMapping("main.do")
	public String loginMain(HttpSession session , Model model) {
		String id = (String)session.getAttribute("memId");
		TestVO vo = (TestVO)sql.selectOne("test.selectUser",id);
		model.addAttribute("vo", vo);
		return "/test/main";
	}
	
	@RequestMapping("loginForm.do")
	public String logform() {
		return "/test/loginForm";
	}
	
	@RequestMapping("loginPro.do")
	public String logPro(TestVO vo , HttpSession session , Model model) {
		int c = (Integer)sql.selectOne("test.loginCheck", vo);
		if(c == 1) {
			session.setAttribute("memId", vo.getId());
		}
		model.addAttribute("c",c);
		return "/test/loginPro";
	}
	
	@RequestMapping("modifyForm.do")
	public String loginModifyForm(HttpSession session , Model model) {
		String id = (String)session.getAttribute("memId");
		TestVO vo = (TestVO)sql.selectOne("test.selectUser",id);
		model.addAttribute("vo", vo);
		return "/test/modifyForm";
	}
	
	
	
	
	
	@RequestMapping("modifyPro.do")
	public String loginModifyPro(MultipartHttpServletRequest request , 
								 HttpSession session , Model model ,
								 String pw , int age , String name , String org) {
		
		String id = (String)session.getAttribute("memId");
		MultipartFile mf = request.getFile("img");
		String orgname=mf.getOriginalFilename();
		TestVO vo = new TestVO();
		vo.setAge(age);
		vo.setName(name);
		vo.setPw(pw);
		vo.setId(id);
		if(orgname.equals("")) {
			vo.setImg(org);
		}else {
			String path = request.getRealPath("imgs");
			String ext = orgname.substring(orgname.lastIndexOf("."));
			String img = id+ext;
			File f = new File(path+"//"+img);
			try {
				mf.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			vo.setImg(img);
		}
		
		sql.update("test.updateModify" , vo);
		
		return "/test/modifyPro";
	}
	
	
	
	
	
	@RequestMapping("deleteForm.do")
	public String loginDeleteForm() {
		return "/test/deleteForm";
	}
	@RequestMapping("logout.do")
	public String loginLogout(HttpSession session) {
		session.invalidate();
		return "/test/logout";
	}
}




















