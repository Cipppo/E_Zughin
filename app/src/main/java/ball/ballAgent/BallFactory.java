package ball.ballAgent;

import java.util.Random;

import ball.Boundary;
import ball.physics.*;
/**
 * Generator of Various kind of Balls, 
 */
public class BallFactory {
	
	private static final double MAX_ANGLE = 80;
    private static final double MIN_ANGLE = 50;
    private static final double MAX_VELOCITY = 150;
    private static final double MIN_VELOCITY = 80;

	private static final double EARTH_GRAVITY = 9.81;
	private static final double MOON_GRAVITY = 1.62;

	private static final double STD_TICK = 0.07;
	
	/**
	 * Creates a ball with a random angle, a random initialVelocity
	 * and with Earth's gravitational force; 
	 * @param pos
	 * 			initial position of the ball
	 * @return a new ball with random angle, initialVelocity and Earth gravity.
	 */
	private static Ball randomVelAndAngleBall(final SpherePos2D pos) {
		Random rand = new Random();
        var angle = rand.nextDouble() * (MAX_ANGLE - MIN_ANGLE) + MIN_ANGLE;
        var initialVelocity = rand.nextDouble() * (MAX_VELOCITY - MIN_VELOCITY) + MIN_VELOCITY;
        
        return completeBall(angle, initialVelocity, pos, EARTH_GRAVITY, STD_TICK);
	}

	/**
	 * Creates a ball with random X values and starting from the 
	 * top of the stage.
	 * @return a random position ball.
	 */
	public static Ball randomPos() {
		Random rand = new Random();
		SpherePos2D pos = new SpherePos2D(rand.nextDouble(), Boundary.Y0.getValue(), Dimensions.FATHER, 50);
		return randomVelAndAngleBall(pos);
	}

	/**
	 * 
	 * @return a ball with moon gravity
	 */
	public static Ball moonBall() {
		var ball = randomPos();
		return completeBall(
			ball.getTrajectory().getAngle(),
			ball.getTrajectory().getInitialVelocity(),
			new SpherePos2D(ball.getPosition().getX(),
				ball.getPosition().getY(),
				ball.getPosition().getDimension(),
				ball.getSize()),
			MOON_GRAVITY,
			STD_TICK);
	}

	/**
	 * This method creates a ball with the specified speed.
	 * The higher the tick is, the fastest is the ball (Harder Game).
	 * @param tick
	 * 			how fast the ball goes.
	 * 			NOTE: std value is 0.09
	 * @return
	 * 		a ball with the specified tickSpeed
	 */
	public static Ball speedBall(double tick) {
		var ball = randomPos();
		return completeBall(ball.getTrajectory().getAngle(), 
				ball.getTrajectory().getInitialVelocity(), 
				new SpherePos2D(ball.getPosition().getX(), 
						ball.getPosition().getY(), 
						ball.getPosition().getDimension(), 
						ball.getSize()),
				EARTH_GRAVITY, 
				tick);
	}

	/**
	 * Creates a ball from scratch, with given specific parameters.
	 * 
	 * @param angle
	 * @param initialVelocity
	 * @param position 
	 * 			the inital position
	 * @param gravity
	 * 
	 * @return a ball with specified parameters.
	 */
	public static Ball completeBall(double angle, double initialVelocity, SpherePos2D position, double gravity, double tick) {
		Trajectory traj = new Trajectory(angle, initialVelocity);
		return new Ball(traj, position, gravity, tick);
	}
	
	/**
	 * Creates a Ball with same values of the father (initialVelocity,
	 * angle, position) but the updated Value of Dimensions, meaning that
	 * a FATHER given as argument will craete two SONs ans
	 * a SON will create two GRANDSONs.
	 * @param ball
	 * 			the father ball
	 * @return
	 * 			a child ball
	 */
	public static Ball fromFatherBall(final Ball ball) {
		SpherePos2D newPos = new SpherePos2D(
			ball.getPosition().getX(),
			ball.getPosition().getY(),
			Dimensions.getChild(ball.getPosition().getDimension()),
			ball.getSize()
		);
		
		return completeBall(
			ball.getTrajectory().getAngle(),
			ball.getTrajectory().getInitialVelocity(),
			newPos,
			EARTH_GRAVITY,
			STD_TICK);
	}
}
