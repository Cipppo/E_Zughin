package fruit;

import java.awt.Color;
import java.util.Random;

import mergeballs.utilities.EntityPos2D;
import pangGuy.character.Hero;
import pangGuy.gui.Shape;
import pangGuy.utilities.Pair;
import player.Player;

public class FruitController extends Thread{
	private static final int FRUIT_WIDTH = 17;
    private static final int FRUIT_HEIGHT = 17;
    private static final int SPAWN_TIME = 10;
    private Fruit fruit;
    private FruitImplementation fImplementation;
    
    private final Player player;
    private Pair<Integer, Integer> bounds;
    private boolean isRunning;
    
    
    public FruitController(Player player, Pair<Integer, Integer> bounds) {
    	this.player = player;
    	this.bounds = bounds;
    	this.isRunning = false;
    }
    
    @Override
    public void run() {
    	fruit = new Fruit(200); //futura mappa di frutti
    	fruit.setBounds(17,17,0,0);
    	fruit.setBackground(Color.BLACK);
    	while(isRunning) {
    		try {
				fImplementation = new FruitImplementation(fruit, this.generateRandomShape());
				System.out.println("Spawned");
                Thread.sleep(SPAWN_TIME * 1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    }
    
    public Fruit getFruit() {
    	return this.fruit;
    }
    
    private synchronized EntityPos2D getRandomPos2D() {
        Random rand = new Random();
       return new EntityPos2D(rand.nextInt(this.bounds.getX()), this.bounds.getY() - 55);
    }
    
    private synchronized Shape generateRandomShape(){
        return new Shape(this.getRandomPos2D(), FRUIT_WIDTH, FRUIT_HEIGHT);
    }
}
