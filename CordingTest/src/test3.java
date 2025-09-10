import java.util.Scanner;

public class test3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("공백으로 구분하여 숫자 배열을 입력하세요");
		String str = scan.nextLine();
		String[] array = str.split(" ");
	
		int winner = 0;
		
		if(array != null) {
			for(int i = 0; i < array.length -1; i++ ) {
				String aStr = array[i];
				int a = Integer.parseInt(aStr);
				
				
				
				
				if( winner > a) {
					winner = winner;
				} else {
					winner = a;
				}
			}
			System.out.println("가장 큰 수는 " + winner + "입니다.");
		} else {
			System.out.println("공백입니다.");
		}
		
		
	}
}
