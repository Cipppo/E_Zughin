package ball.controller;

import ball.ballAgent.*;
import ball.physics.SpherePos2D;
import pangGuy.gui.Shape;
import ball.Boundary;

public class BallBoundChecker {
    private final double width;
    private final double height;
    
    public BallBoundChecker(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Check collisions beetween balls and walls.
     * Expecially in X0 and Y1 there are offsets, due to strange behaviour
     * of swing graphical interface (and MacOS).
     * 
     * @param t
     *          the ball to check 
     */
    public void checkConstraints(BallAgent t) {
        final var x =  (t.getBallPosition().x * this.width);
        final var y =  (t.getBallPosition().y * this.height);
        final int diameter = t.getBallPosition().getDiameter();
        if (x < 0) {
            t.applyConstraints(Boundary.X0.getValue() , Boundary.X0);
        } else if (x + diameter >= this.width) {
            t.applyConstraints(t.getBallPosition().x - (diameter * 0.0001), Boundary.X1);
        } else if (y + 1.65 * diameter > this.height) { //very problematic in macos
            t.applyConstraints(t.getBallPosition().y - 0.009, Boundary.Y1);
        } else if (y < -1) {
            t.applyConstraints(Boundary.Y0.getValue(), Boundary.Y0);
        }
    }

        /**
     * Checks wether a ball hits a {@link pangGuy.gui.Shape} or not.
     * 
     * @param entity
     *          rectangular shaped entity
     * @param ball 
     *          spherical shaped entity
     * @return
     *          true if the two enemies collides
     */
    public boolean checkEnemyCollision(Shape entity, BallAgent ball) {
        var bPos = new SpherePos2D(ball.getBallPosition().x * this.width,
                        ball.getBallPosition().y *  this.height,
                        ball.getBallPosition().getDimension(),
                        ball.getSize());

        return IntersectionChecker.isCollision(bPos, entity);
    }
}