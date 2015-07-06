package my.pattern.decorator;

public class Beef extends FoodDecorator {

	public Beef() {
		
	}
	
	public Beef(Food foodParam) {
		super(foodParam);
	}

	@Override
	public int getCost() {
		return 20 + super.getCost();
	}

	@Override
	public String getDescription() {
		return "Beef " + super.getDescription();
	}
}