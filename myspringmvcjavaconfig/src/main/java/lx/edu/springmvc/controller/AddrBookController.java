package lx.edu.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.edu.springmvc.dao.AddrBookDAO;
import lx.edu.springmvc.dao.RequestLogDAO;
import lx.edu.springmvc.vo.AddrBookVO;
import lx.edu.springmvc.vo.RequestLogVO;

@Controller
public class AddrBookController {
	
	@Autowired
	AddrBookDAO dao;
	
   
	@RequestMapping("/addrbook_form.do")
	public String form() {
		return "addrbook_form"; //jsp file name
	}
	
	@RequestMapping("addrbook_list.do")
	public String list(HttpServletRequest req, HttpSession session) throws Exception {
		if(session.getAttribute("userId") == null) {
			return "login";
		}
		List<AddrBookVO> list = dao.getDBList();
		// list를 request에 넣는다 
		req.setAttribute("data", list);
		return "addrbook_list";
	}
	
//	@RequestMapping("addrbook_list.do")
//	public ModelAndView list(HttpSession session) throws Exception {
//		ModelAndView result = new ModelAndView();
//		List<AddrBookVO> list = dao.getDBList();
//		result.addObject("data", list);
//		result.setViewName("addrbook_list");
//		return result;
//	}
	
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
