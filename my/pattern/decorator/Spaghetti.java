package my.pattern.decorator;

public class Spaghetti extends FoodDecorator {

	public Spaghetti() {
	}
	
	public Spaghetti(Food foodParam) {
		super(foodParam);
	}

	@Override
	public int getCost() {
		return 15 + super.getCost();
	}

	@Override
	public String getDescription() {
		return "Spaghetti " + super.getDescription();
	}
}