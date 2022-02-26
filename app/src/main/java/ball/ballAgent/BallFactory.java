package ball.ballAgent;

import java.util.Random;

import ball.Boundary;
import ball.physics.*;

public class BallFactory {
	
	private static final double MAX_ANGLE = 80;
    private static final double MIN_ANGLE = 50;
    private static final double MAX_VELOCITY = 150;
    private static final double MIN_VELOCITY = 80;
    
	
	/**
	 * Ball that starts from top down-left border of the frame
	 * withg random angle and random initial velocity;
	 * @return a ball with random velocity and angle;
	 */
	public static Ball randomVelAndAngleBall() {
		Random rand = new Random();
        var angle = rand.nextDouble() * (MAX_ANGLE - MIN_ANGLE) + MIN_ANGLE;
        var initialVelocity = rand.nextDouble() * (MAX_VELOCITY - MIN_VELOCITY) + MIN_VELOCITY;
        
        Pos2D pos = new Pos2D(Boundary.X0.getValue(), Boundary.Y1.getValue(), Dimensions.FATHER);
        
        return completeBall(angle, initialVelocity, pos, 9.81);
	}
	
	/**
	 * 
	 * @return a ball with specified parameters
	 */
	public static Ball completeBall(double angle, double initialVelocity, Pos2D position, double gravity) {
		Trajectory traj = new Trajectory(angle, initialVelocity);
		return new Ball(traj, position, gravity);
	}
}
