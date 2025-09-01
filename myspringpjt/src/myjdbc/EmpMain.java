package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import myjdbc.EmpDAO;

public class EmpMain {
	public static void main(String[] args) throws Exception {

		int deptNo = 100;
		EmpDAO dao = new EmpDAO();
		EmpService service = new EmpServiceImpl();
		service.setDAO(dao);
		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
		for (Emp emp : empList) {
			System.out.println(emp);
		}

	}
}