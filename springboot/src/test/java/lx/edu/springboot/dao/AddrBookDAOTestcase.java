package lx.edu.springboot.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import lx.edu.springboot.vo.AddrBookVO;

@SpringBootTest
public class AddrBookDAOTestcase {

	@Autowired
	AddrBookDAO dao;
	
	@Test
	public void testGetDBList() throws Exception {
		List<AddrBookVO> list = dao.getDBList();
		assertEquals(list.size()>0, true);
	}
}


