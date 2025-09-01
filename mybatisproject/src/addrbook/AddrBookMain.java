package addrbook;

import java.util.List;

public class AddrBookMain {
	 public static void main(String[] args) throws Exception {
		 System.out.println("addbook id list");
		 List<AddrBookVO> list = new AddrBookDAO().getDBList();
		 for(AddrBookVO vo : list) {
			 System.out.println(vo);
			 
		 }
	}
}
