package myjdbc;

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

import myjdbc.EmpDAO;

public class EmpMainSpring {
	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		// Container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		
		// 생성되고 있는 bean들의 name 확인
		String[] nameList = context.getBeanDefinitionNames();
		for(String name : nameList) System.out.println(name);
		
		// Container가 만든 bean을 가져오기
		EmpService service = (EmpService) context.getBean("service");
		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
		
		/*
		EmpDAO dao = new EmpDAO();
		EmpService service = new EmpServiceImpl();
		service.setDAO(dao);
		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
		*/
		
		for (Emp emp : empList) {
			System.out.println(emp);
		}

	}
}