package assignment01;

import java.util.List;

public interface EmpService {

	
	// 메서드를 선언한 것
	List<Emp> getEmpListByDeptNo(int deptNo) throws Exception;
	
	List<Emp> findEmpByYear(int year) throws Exception;

}
