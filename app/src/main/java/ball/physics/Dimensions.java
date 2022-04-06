package ball.physics;

public enum Dimensions {
	FATHER(1.0),
	SON(0.85),
	GRANDSON(0.50),
	STD(1.0),
	NONE(0.0);

	private final double n;

	private Dimensions(final double n) {
		this.n = n;
	}

	public double getValue() {
		return this.n;
	}

	//maybe implement an exception than that null
	public static Dimensions getChild(Dimensions dim) {
		switch (dim) {
			case FATHER:
				return SON;
			case SON:
				return GRANDSON;
			default:
				return null;
		}
	}
}