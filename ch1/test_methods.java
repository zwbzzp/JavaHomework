package ch1;

public class test_methods {
	public static void main(String[] args) {
		Test t = new Test();
//		t.test('A');
//		t.test(3.0f);
//		t.test((byte)1);
//		t.test('A','B');
	}
	
}

class Test{
	public void test(char x){
		System.out.println("char");
	}
	
	public void test(int x) {
		System.out.println("int");
	}
	
	public void test(char x, int y) {
		System.out.println("char, int");
	}
	
	public void test(int x, char y) {
		System.out.println("int, char");
	}
}
