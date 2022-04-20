package ball.physics;

/**
 * This class models the various Dimensions that a {@link ball.ballAgent.Ball} can 
 * be. Each dimension has a numerical value (beetween 1 and 0) used for calulating
 * the diameter of a ball, given the standard diameter (in our case 50px).
 */
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

	/**
	 * 
	 * @param dim : the {@link ball.physics.Dimensions} of the ball we want to find the child
	 * @return the child {@link ball.physics.Dimensions} if it's not a {@link ball.physics.Dimensions#GRANDSON},
	 * 			else it returns {@link ball.physics.Dimensions#NONE}
	 */
	public static Dimensions getChild(Dimensions dim) {
		switch (dim) {
			case FATHER:
				return SON;
			case SON:
				return GRANDSON;
			default:
				return NONE;
		}
	}
}