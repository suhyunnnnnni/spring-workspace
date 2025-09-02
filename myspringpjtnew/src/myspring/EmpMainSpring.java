package myspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myspring.EmpDAO;

public class EmpMainSpring {
	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		// Container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		
		// Container가 만든 Bean을 가져오기
		EmpService service = (EmpService) context.getBean("empServiceImpl");
//		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
//		
//		for (Emp emp : empList) {
//			System.out.println(emp);
//		}
		
		String firstName = null;
		String lastName = "King";
		List<Emp> emp = service.getEmpByFirstNLastName(firstName, lastName);
		System.out.println(emp);

	}
}