package myjdbc;

public class VariableObject {
	public static void main(String[] args) {
		Product product1 = new Product();
		Product product2 = new Product();
		product2.price = 5000;
		System.out.println(product1.price);
		product1 = product2;
		System.out.println(product1.price);
	}
}

class Product {
	int price;
	String name;
	String maker;
}
