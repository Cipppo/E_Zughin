package ball.ballAgent;

import java.util.Random;

import ball.Boundary;
import ball.physics.*;
/**
 * TODO: add a method for creating a ball from given initialVelocity 
 * used by duplicate method; need to define were to put that duplication(Ball || BallAgent)
 */
public class BallFactory {
	
	private static final double MAX_ANGLE = 80;
    private static final double MIN_ANGLE = 50;
    private static final double MAX_VELOCITY = 150;
    private static final double MIN_VELOCITY = 80;

	private static final double EARTH_GRAVITY = 9.81;
	
	/**
	 * 
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
	 * 
	 * @return a ball with random X and Y values.
	 */
	public static Ball randomPos() {
		Random rand = new Random();
		Pos2D pos = new Pos2D(rand.nextDouble(), Boundary.Y1.getValue() / 2, Dimensions.FATHER);
		return randomVelAndAngleBall(pos);
	}

	/**
	 * 
	 * @return a ball with specified parameters.
	 */
	public static Ball completeBall(double angle, double initialVelocity, Pos2D position, double gravity) {
		Trajectory traj = new Trajectory(angle, initialVelocity);
		return new Ball(traj, position, gravity);
	}

	public static Ball fromFatherBall(final Ball ball) {
		Pos2D newPos = new Pos2D(
			ball.getCurrentPosition().x,
			ball.getCurrentPosition().y,
			Dimensions.getChild(ball.getCurrentPosition().getDimension())
		);
		
		return completeBall(
			ball.getTrajectory().getAngle(),
			ball.getTrajectory().getInitialVelocity(),
			newPos,
			EARTH_GRAVITY
		);
	}
}
