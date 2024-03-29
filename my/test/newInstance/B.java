package my.test.newInstance;

import static java.lang.System.out;

import java.lang.reflect.Constructor;

public class B {
	public static void main(String[] args) {
		B b = new B();
		out.println("通过Class.NewInstance()调用私有构造函数:");
		b.newInstanceByClassNewInstance();
		out.println("通过Constructor.newInstance()调用私有构造函数:");
		b.newInstanceByConstructorNewInstance();
	}
	
	private void newInstanceByClassNewInstance(){
		try {/*当前包名为reflect，必须使用全路径*/
		A a=(A)Class.forName("my.test.newInstance.A").newInstance();
		} catch (Exception e) {
		out.println("通过Class.NewInstance()调用私有构造函数【失败】");
		}
		} 
	
	private void newInstanceByConstructorNewInstance(){
		try {/*可以使用相对路径，同一个包中可以不用带包路径*/
		Class c=Class.forName("my.test.newInstance.A");
		/*以下调用无参的、私有构造函数*/
		Constructor c0=c.getDeclaredConstructor();
		c0.setAccessible(true);
		A a0=(A)c0.newInstance();
		/*以下调用带参的、私有构造函数*/
		Constructor c1=c.getDeclaredConstructor(new Class[]{int.class,int.class});
		c1.setAccessible(true);
		A a1=(A)c1.newInstance(new Object[]{5,6});
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
}