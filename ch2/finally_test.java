package ch2;

import ch1.test_methods;

public class finally_test {
	public static void main(String[] args) {
		int t = test();
		System.out.println(t);
	}
	static int test(){ 
		try {
			System.out.println("try block");
			return 1;
		} catch (Exception e) {
			return 2;
		}
		finally{
			System.out.println("finally block");
			return 3;
		}
	}
}
