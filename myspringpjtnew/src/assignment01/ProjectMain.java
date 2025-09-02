package assignment01;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment01.Emp;
import assignment01.EmpService;

public class ProjectMain {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in); 
		  int way=10;
	      while(way!=0) {
	         System.out.println("<원하는 검색방법 번호를 입력하세요>(0 입력시 종료됩니다)");
	         System.out.println("1.입사년도 2.부서번호을 통한 부서원검색");
	         try {
	         way = scan.nextInt();
	         } catch (InputMismatchException e) {
	             System.out.println("숫자로 다시 입력해주세요.");
	             scan.nextLine();
	             continue;
	         }
	         switch(way) {
	         case 1:
	        	searchByYear();
	            break;
	         case 2:
	        	searchByDeptId();
	            break;
	         default:
	            System.out.println("선택지에 없는 번호입니다.");
	            break;
	         }
	      }
	      System.out.println("-프로그램 종료-");
	   }

	
	static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context2.xml");
	static EmpService service = (EmpService) context.getBean("empServiceImpl");
	
	public static void searchByYear() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("입사연도 입력(YYYY) : ");
		int year = scan.nextInt();
		while(year!=0) {
			List<Emp> list = service.findEmpByYear(year);
			for(int i=0; i<list.size(); i++) {
				Emp temp = list.get(i);
				System.out.println("사번 :"+temp.empId+", 이름 :"+temp.firstName+" "+temp.lastName+", 이메일 :"+temp.email+", 입사일자 :"+temp.hireDate+", 급여:"+temp.salary+", 부서번호 :"+temp.deptId);		
			}
			System.out.println("연도 입력(0은 종료) : ");
			year = scan.nextInt();
		}
	}

	public static void searchByDeptId() throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.println("부서번호 입력 : ");
		int dept = scan.nextInt();
		while(dept!=0) {
			List<Emp> list = service.getEmpListByDeptNo(dept);
			for(int i=0; i<list.size(); i++) {
				Emp temp = list.get(i);
				System.out.println("사번 :"+temp.empId+", 이름 :"+temp.firstName+" "+temp.lastName
							+", 이메일 :"+temp.email+", 입사일자 :"+temp.hireDate
							+", 급여:"+temp.salary+", 부서번호 :"+temp.deptId);		
			}
			System.out.println("부서번호 입력(0은 종료) : ");
			dept = scan.nextInt();
		}
	}

}
