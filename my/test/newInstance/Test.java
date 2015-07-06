package my.test.newInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] argu) {
//		ClassNewInstanceTest(ClassA.class);
		ConstractorNewInstanceTest(ClassA.class);
	}
	
	public static void ClassNewInstanceTest(Class c) {
		System.out.print("class newInstance test:");
		try {
			c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ConstractorNewInstanceTest(Class c) {
		try {
			System.out.println("default constractor newInstance test:");
			Constructor consturctor1 = c.getDeclaredConstructor();
			consturctor1.setAccessible(true);
			consturctor1.newInstance();
			System.out.println("default constractor with arguments newInstance test:");
			Constructor consturctor2 = c.getDeclaredConstructor(new Class[]{int.class, int.class});
			consturctor2.setAccessible(true);
			consturctor2.newInstance(new Object[]{5,6});
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
