package my.pattern.adapter;

public class test {
	
	public static void main(String[] agruments) {
		DonaldDuck donaldDuck = new DonaldDuck();
		TurkeyAdapter turkey = new TurkeyAdapter(donaldDuck);
		turkey.fly();
		turkey.gobble();
	}
}
