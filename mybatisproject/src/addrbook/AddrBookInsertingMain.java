package addrbook;

import java.util.List;

public class AddrBookInsertingMain {
	 public static void main(String[] args) throws Exception {
		 System.out.println("addbook id list");
		 AddrBookVO vo = new AddrBookVO();
		 vo.abName = "haha";
		 vo.abEmail = "jaja@naver.com";
		 vo.abTel = "010-2000-2000";
		 boolean result = new AddrBookDAO().insertDB(vo);
		 System.err.println(result);
	}
}
