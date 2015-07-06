package my.pattern.adapter;

public class DonaldDuck implements Duck {

	@Override
	public void quack() {
		System.out.println("Donald, Donald, ga.. gaa..");
	}

	@Override
	public void fly() {
		System.out.println("See me Donald fly...");
	}
}