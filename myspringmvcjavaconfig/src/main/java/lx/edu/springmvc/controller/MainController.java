package lx.edu.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MainController {


	@GetMapping("login_form.do")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("login_action.do")
	public String logintAction(HttpServletRequest req,@RequestParam("id") String id, 
								@RequestParam("pw") String pw, HttpSession session) {
		// id, pw
		System.out.println("id=" + id + ", pw=" + pw);
		if(id.equals(pw)) { // login한 것으로 처리함
			session.setAttribute("userId", id);
			return "redirect:addrbook_list.do";
		}
		return "redirect:login_form.do";
	}
}
