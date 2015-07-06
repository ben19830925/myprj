package my.pattern.adapter;

public class ShortHairTurkey implements Turkey {

	@Override
	public void gobble() {
		System.out.println("In my worlds, we just gobble, cannot quack.");
	}

	@Override
	public void fly() {
		System.out.println("See I'm flying, slow.");
	}

}