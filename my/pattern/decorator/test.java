package my.pattern.decorator;

public class test {
	
	public static void main(String[] agruments) {
		Food order = new Rice(new Beef(new Spaghetti()));
		System.out.println("Order list: "+ order.getDescription());
		System.out.println("Total: "+ order.getCost());
	}
}
