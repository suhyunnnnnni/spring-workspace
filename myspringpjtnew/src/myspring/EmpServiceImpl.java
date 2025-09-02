package myspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// EmpServiceImpl이 EmpDAO를 의존하고 있구나.
@Service 
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpDAO dao;

	

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		
		return dao.getEmpListByDeptNo(deptNo);
	}



	@Override
	public List<Emp> getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		return dao.getEmpByFirstNLastName(firstName, lastName);
	}

}
// setter메서드, EmpService에서 선언한 추상메소들 정의함, EmpDAO 클래스 객체 변수가 존재
