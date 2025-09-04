package lx.edu.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import lx.edu.springmvc.dao.AddrBookDAO;
import lx.edu.springmvc.vo.AddrBookVO;

@Controller
public class AddrBookController {

    private final HelloController helloController;
	
	@Autowired
	AddrBookDAO dao;

    AddrBookController(HelloController helloController) {
        this.helloController = helloController;
    }
	
	@RequestMapping("/addrbook_form.do")
	public String form() {
		return "addrbook_form"; //jsp file name
	}
	
//	@RequestMapping("addrbook_list.do")
//	public String list(HttpServletRequest req) throws Exception {
//		List<AddrBookVO> list = dao.getDBList();
//		// list를 request에 넣는다 
//		req.setAttribute("data", list);
//		return "addrbook_list";
//	}
	
	@RequestMapping("addrbook_list.do")
	public ModelAndView list() throws Exception {
		ModelAndView result = new ModelAndView();
		List<AddrBookVO> list = dao.getDBList();
		result.addObject("data", list);
		result.setViewName("addrbook_list");
		return result;
	}
	
	@RequestMapping("/insert.do")
	public String insert(AddrBookVO vo) throws Exception {
		System.out.println(vo);
		dao.insertDB(vo);
		return "redirect:addrbook_list.do";
	}
	
	@RequestMapping("/edit.do")
	public String edit(@RequestParam("abId") int abId, HttpServletRequest req) throws Exception {
		AddrBookVO vo = dao.getDB(abId);
		req.setAttribute("ab", vo);
		return "addrbook_edit_form";
	}
	
	@RequestMapping("/update.do")
	public String update(AddrBookVO vo, HttpServletRequest req) throws Exception {
		dao.updateDB(vo);
		return "redirect:addrbook_list.do";
	}
}
