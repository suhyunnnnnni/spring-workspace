package myspring;

import java.util.List;

public interface EmpService {

	
	// 메서드를 선언한 것
	List<Emp> getEmpListByDeptNo(int deptNo) throws Exception;

}
