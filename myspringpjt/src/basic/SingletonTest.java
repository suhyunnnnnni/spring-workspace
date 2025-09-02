package basic;

public class SingletonTest {
	public static void main(String[] args) {
		//MySingleton singleton1 = new MySingleton();
		MySingleton singleton1 = MySingleton.getInstance();
		//MySingleton singleton2 = new MySingleton();
	}
}

class MySingleton {
	private static MySingleton me = new MySingleton();
	private MySingleton() {
		System.out.println("MySingleton");
	}
	
	public static MySingleton getInstance() {
		return me;
	}
}