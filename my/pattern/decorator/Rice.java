package my.pattern.decorator;

public class Rice extends FoodDecorator {

	public Rice() {
		
	}
	
	public Rice(Food foodParam) {
		super(foodParam);
	}

	@Override
	public int getCost() {
		return 5 + super.getCost();
	}

	@Override
	public String getDescription() {
		return "Rice " + super.getDescription();
	}
}