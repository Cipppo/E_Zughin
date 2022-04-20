package fruit;

import pangGuy.gui.Shape;
//import player.Player;
import powerUp.Pickable;

public class FruitImplementation extends Pickable{
	
	
	private boolean isActived;
	private Fruit fruit;
	
	public FruitImplementation(Fruit fruit, Shape shape) {
		super(shape);
		this.fruit = fruit;
		this.isActived = true;
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		if (!this.isActived) {
			this.isActived = true;
			this.fruit.activate();
		}
		
	}
}

	