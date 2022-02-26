package ball;

public enum Boundary {
	X0(0),
	Y0(0),
	X1(1),
	Y1(1);
	
	private final int n;
	
	private Boundary(final int n) {
		this.n = n;
	}
	
	public int getValue() {
		return this.n;
	}
	
}