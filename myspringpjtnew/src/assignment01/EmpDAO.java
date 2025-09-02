package assignment01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	
	@Autowired
	SqlSession session;
	
	public List<Emp> findEmpByYear(int year) throws Exception {
		return session.selectList("findEmpByYear", year);
	}
	public List<Emp> findEmpByDeptId(int deptId) throws Exception {
		return session.selectList("getEmpListByDeptId", deptId);
	}
	
}
