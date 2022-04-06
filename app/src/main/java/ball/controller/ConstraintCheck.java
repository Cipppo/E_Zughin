package ball.controller;

import ball.Boundary;
import ball.ballAgent.BallAgent;
import ball.physics.Entity;
import ball.physics.Pos2D;
import ball.utils.Pair;
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

    public boolean checkEnemyCollision(Entity entity, BallAgent ball) {
        var bPos = new Pos2D(ball.getBallPosition().x * this.width,
                        ball.getBallPosition().y *  this.height,
                        ball.getBallPosition().getDimension(),
                        ball.getSize());

        var ePos = new Pos2D(entity.getPosition().x,
                            entity.getPosition().y,
                            entity.getPosition().getDimension(),
                            entity.getSize());
        return isCollision(bPos, ePos, bPos.getDiameter() + ePos.getDiameter());
    }

    public boolean isCollision(Pos2D ball, Pos2D entity, int delta) {
        Pair<Integer> aCenter = new Pair<Integer>((int)(ball.x + (ball.getDiameter() / 2)), (int)(ball.y + (ball.getDiameter() / 2) ));
        Pair<Integer> bCenter = new Pair<Integer>((int)(entity.x + (entity.getDiameter() / 2)), (int)(entity.y + (entity.getDiameter() / 2)));

        System.out.println(aCenter + " " + bCenter + " Ball Radius: " + ball.getDiameter() + " Obstacle Radius: " + entity.getDiameter());

        return ((int)Math.hypot(aCenter.getX() - bCenter.getX(), aCenter.getY() - bCenter.getY()) <= delta);
    }
}