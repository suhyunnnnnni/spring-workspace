import java.util.Arrays;
import java.util.Scanner;

public class test2 {
	// 전달받은 문자열이 회문(앞으로나 뒤로나 동일한 문자열)문자열인지 체크하는 메서드를 완성하시오
	public static void main(String[] args) {
		System.out.println("문자열을 입력하세요");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] list = input.split("");
		
		boolean check = true;
		
		for(int i = 0; i< list.length / 2; i++) {
			int index = list.length -1 - i;
			if(!list[i].equals(list[index])) {
				check = false;
				break;
			} 
		}
		
		if(!check) {
			System.out.println("회문 아닙니다.");
		} else {
			System.out.println("회문입니다");
		}
		
		
		
	}
	
	
}
