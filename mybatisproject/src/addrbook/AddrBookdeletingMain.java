package addrbook;

import java.util.List;
import java.util.Scanner;

public class AddrBookdeletingMain {
	 public static void main(String[] args) throws Exception {
		 System.out.println("삭제할 아이디를 입력하세요");
		 Scanner scan = new Scanner(System.in);
		 int deleteId = scan.nextInt();
		 boolean result = new AddrBookDAO().deleteDB(deleteId);
		 System.err.println(result);
		 
	}
}
