package ball.controller;

import ball.Boundary;
import ball.ballAgent.BallAgent;
import ball.physics.SpherePos2D;
import ball.utils.Pair;
import pangGuy.gui.Shape;

public class ConstraintCheck {
    private final double width;
    private final double height;
    
    public ConstraintCheck(double width, double height) {
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

        return isCollision(bPos, entity);
    }

    private boolean isCollision(SpherePos2D ball, Shape rect) {
        var rectWidht = rect.getDimensions().getX();
        var rectHeight = rect.getDimensions().getY();
        Pair<Integer> rectCenter = new Pair<Integer>(rect.getPos().x + (int)(0.5*rectWidht),
                                                    rect.getPos().y + (int)(0.5*rectHeight));
        Pair<Integer> ballCenter = new Pair<Integer>((int)(ball.x + (ball.getDiameter() / 2)), (int)(ball.y + (ball.getDiameter() / 2) ));
        Pair<Integer> circleDistance = new Pair<Integer>(0,0);
        
        circleDistance.setX(Math.abs(ballCenter.getX() - rectCenter.getX()));
        circleDistance.setY(Math.abs(ballCenter.getY() - rectCenter.getY()));

        // Base cases, the two figures don't intersect
        if (circleDistance.getX() > (rectWidht / 2 + ball.getDiameter() / 2)) {
            return false;
        }

        if (circleDistance.getY() > (rectHeight / 2 + ball.getDiameter() / 2)) {
            return false;
        }

        //Simple intersection (circle intersect rectangle)
        if (circleDistance.getX() <= (rectWidht / 2) || circleDistance.getY() <= (rectHeight / 2)) {
            return true;
        }
        //Check distance of circle from corners of the rectangle.
        var cornerDistance_sq = Math.hypot(circleDistance.getX() - rectWidht / 2, circleDistance.getY() - rectWidht / 2);
        return (cornerDistance_sq <= (Math.pow(ball.getDiameter() / 2, 2)));
    }
}