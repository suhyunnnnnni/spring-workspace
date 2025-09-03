package lx.edu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AddrBookController {
	
	@Autowired
	AddrBookDAO dao;
	
	@RequestMapping("/addrbook_form.do")
	public String form() {
		return "addrbook_form"; //jsp file name
	}
	
	@RequestMapping("addrbook_list.do")
	public String list(HttpServletRequest req) throws Exception {
		List<AddrBookVO> list = dao.getDBList();
		// list를 request에 넣는다 
		req.setAttribute("data", list);
		return "addrbook_list";
	}
	
	@RequestMapping("/insert.do")
	public String insert(AddrBookVO vo) throws Exception {
		System.out.println(vo);
		dao.insertDB(vo);
		return "redirect:addrbook_list.do";
	}
}
