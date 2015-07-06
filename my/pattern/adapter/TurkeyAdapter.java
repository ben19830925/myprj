package my.pattern.adapter;

public class TurkeyAdapter implements Turkey {
	Duck duck;
	
	public TurkeyAdapter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		duck.fly();
	}
}