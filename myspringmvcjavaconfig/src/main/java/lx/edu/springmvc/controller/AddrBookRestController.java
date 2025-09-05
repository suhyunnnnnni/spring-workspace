package lx.edu.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lx.edu.springmvc.dao.AddrBookDAO;
import lx.edu.springmvc.vo.AddrBookVO;

@RestController
public class AddrBookRestController {
	
	@Autowired
	AddrBookDAO dao;
	
	@RequestMapping("/addrbooks/{id}")
	//id를 전달받아서 해당 방명록을 JSON으로 리턴
	public AddrBookVO getAddrBook(@PathVariable("id") int id) throws Exception  {
		//id로 dao 메서드 호출해서 방명록 정보를 조회하기
		AddrBookVO vo = dao.getDB(id);
		return vo;
	}
	
}
