
/*@RequestMapping(value= "pro.do") // params= {"id=java","!pw"} id=java, pw ����� ���� ����, ���� ���� ���� 
 * value="pro.do","test.do" ���ߺ��� ���� 
 * @RequestParam(value="id" , required=false, defaultValue="hong") String ai)
 * �޼ҵ� �ȿ��� ��ȿ�� �˻� ���� value id�� �־��ָ� String ai �� ���Ե� ���� ���� ����
 * �ʼ� ���� �ɼ����� required 
 * defaultValue null�� ��� �⺻�� ���� ����.
 * @ModelAttribute("vo") FormVO vo  pw ���� �״�� ���� 4.3���� ����,String Ÿ���� �Ұ�
 * */
package frame.spring.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import frame.spring.vo.FormVO;

@Controller
@RequestMapping("/param/")
public class ParamBean {
	
	@RequestMapping("form.do")
	public String form() {
		return "/0711/form";
	}
	
	@RequestMapping(value= "pro.do") // params= {"id=java","!pw"} id=java, pw ����� ���� ����, ���� ���� ���� 
	public String pro(
			@RequestParam(value="id" , required=false, defaultValue="hong") String ai,
			@ModelAttribute("vo") FormVO vo ) {
		System.out.println(ai);
		 return "/0711/pro";
	}
}
