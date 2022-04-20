package fruit;

import javax.swing.JPanel;

public class Fruit extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private boolean isActived;
	private int score;
	
	public Fruit(int score) {
		this.score = score;
		this.isActived = false;
	}
	
	public void activate() {
		this.isActived = true;  
	}
	
	public boolean isActive() {
		return this.isActived;
	}
}
