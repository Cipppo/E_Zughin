package ball.ballAgent;

import java.util.Random;

import ball.Boundary;
import ball.physics.*;
/**
 * Generator of Various kind of Balls, mostly used by testing cases
 * 
 * TODO: try to remove static maybe, discuss it with collegues;
 */
public class BallFactory {
	
	private static final double MAX_ANGLE = 80;
    private static final double MIN_ANGLE = 50;
    private static final double MAX_VELOCITY = 150;
    private static final double MIN_VELOCITY = 80;

	private static final double EARTH_GRAVITY = 9.81;
	private static final double MOON_GRAVITY = 1.62;
	
	/**
	 * Creates a ball with a random angle, a random initialVelocity
	 * and with Earth's gravitational force; 
	 * @param pos
	 * 			initial position of the ball
	 * @return a new ball with random angle, initialVelocity and Earth gravity.
	 */
	private static Ball randomVelAndAngleBall(final Pos2D pos) {
		Random rand = new Random();
        var angle = rand.nextDouble() * (MAX_ANGLE - MIN_ANGLE) + MIN_ANGLE;
        var initialVelocity = rand.nextDouble() * (MAX_VELOCITY - MIN_VELOCITY) + MIN_VELOCITY;
        
        return completeBall(angle, initialVelocity, pos, EARTH_GRAVITY);
	}

	/**
	 * Creates a ball with random X values and starting from the 
	 * top of the stage.
	 * @return a random position ball.
	 */
	public static Ball randomPos() {
		Random rand = new Random();
		Pos2D pos = new Pos2D(rand.nextDouble(), Boundary.Y0.getValue(), Dimensions.FATHER);
		return randomVelAndAngleBall(pos);
	}

	public static Ball moonBall() {
		var ball = randomPos();
		return completeBall(
			ball.getTrajectory().getAngle(),
			ball.getTrajectory().getInitialVelocity(),
			new Pos2D(ball.getPosition().x,
				ball.getPosition().y,
				ball.getPosition().getDimension())
			, MOON_GRAVITY);
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
	public static Ball completeBall(double angle, double initialVelocity, Pos2D position, double gravity) {
		Trajectory traj = new Trajectory(angle, initialVelocity);
		return new Ball(traj, position, gravity);
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
		Pos2D newPos = new Pos2D(
			ball.getPosition().x,
			ball.getPosition().y,
			Dimensions.getChild(ball.getPosition().getDimension())
		);
		
		return completeBall(
			ball.getTrajectory().getAngle(),
			ball.getTrajectory().getInitialVelocity(),
			newPos,
			EARTH_GRAVITY);
	}
}
