package ball.controller;

import ball.Boundary;
import ball.ballAgent.BallAgent;

public class ConstraintCheck {
    private final double width;
    private final double height;
    
    public ConstraintCheck(double width, double height) {
        this.width = width;
        this.height = height;
    }
    /**
     * Valori empirici
     * @param t
     *          the ball to check
     * @param diameter
     *          of the ball in pixels
     */
    public void checkConstraints(BallAgent t, int diameter) {
        final var x =  (t.getBallPosition().x * this.width);
        final var y =  (t.getBallPosition().y * this.height);
        if (x <= 0) {
            t.applyConstraints(Boundary.X0.getValue() + 0.001 , Boundary.X0);
        } else if (x + diameter > this.width) {
            t.applyConstraints(Boundary.X1.getValue() - ( diameter * 0.00125), Boundary.X1);
        } else if (y + diameter > this.height) {
            t.applyConstraints(t.getBallPosition().y - 0.009, Boundary.Y1);
        } else if (y <= -1) {
            t.applyConstraints(Boundary.Y0.getValue() + 0.005, Boundary.Y0);
        }
    }
}