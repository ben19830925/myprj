package my.test.newInstance;

public class ClassA {
	private ClassA() {
		System.out.println("this is the default constractor!");
	}
	
	private ClassA(int i, int j) {
		System.out.println("this is the constractor with i="+i+" and j=" +j);
	}
}
