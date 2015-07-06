package my.pattern.decorator;

public abstract class FoodDecorator extends Food {
	private Food food;
	
	public FoodDecorator() {
	}
	
	public FoodDecorator(Food foodParam) {
		this.food = foodParam;
	}
	
	public int getCost() {
		if(food == null) {
			return 0;
		} else {
			return this.food.getCost();
		}
	}
	
	public String getDescription() {
		if(food == null) {
			return "";
		} else {
			return this.food.getDescription();
		}
	}
}