package myspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	
	
	@Autowired
	SqlSession session;
	


	public  List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		return session.selectList("getEmpListByDeptNo", deptNo);

		
	}

	public  List<Emp> getEmpListByJobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rotrotroot");
		String sql = "select * from employees where job_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, jobId);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}


	public List<Emp> getEmpByFirstNLastName(String firstName, String lastName) {
		Emp emp = new Emp();
		emp.lastName = lastName;
		emp.firstName = firstName;
		return session.selectList("getEmpByFirstNLastName", emp);
	}

}
	
	



