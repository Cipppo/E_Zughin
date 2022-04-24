package ball.controller;

import ball.physics.SpherePos2D;
import ball.utils.SettablePair;
import mergeballs.utilities.EntityShape;

/**
 * Utility class used for checking shapes collisions (intersections).
 */
public class IntersectionChecker {
	
    /**
     * Determine if a Given {@link ball.physics.SpherePos2D} interesects 
     * with a {@link mergeballs.utilities.EntityShape}.
     * @param ball described by {@link ball.physics.SpherePos2D}.
     * @param rect described as a {@link mergeballs.utilities.EntityShape}.
     * @return true if they intersect, false othrewise.
     */
    public static boolean isBallCollision(SpherePos2D ball, EntityShape rect) {
        var rectWidht = rect.getDimensions().getX();
        var rectHeight = rect.getDimensions().getY();
        SettablePair<Integer, Integer> rectCenter = new SettablePair<Integer, Integer>(rect.getPos().getX() + (int)(0.5*rectWidht),
                                                    rect.getPos().getY() + (int)(0.5*rectHeight));
        SettablePair<Integer, Integer> ballCenter = new SettablePair<Integer, Integer>((int)(ball.getX() + (ball.getDiameter() / 2)), (int)(ball.getY() + (ball.getDiameter() / 2) ));
        SettablePair<Integer, Integer> circleDistance = new SettablePair<Integer, Integer>(0,0);
        
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

    /**
     * Determine if two {@link mergeballs.utilities.EntityShape} (two rectangles), overlap each other.
     * @param a the first rectangle ({@link mergeballs.utilities.EntityShape})
     * @param b the second rectangle ({@link mergeballs.utilities.EntityShape})
     * @return true if the two {@link mergeballs.utilities.EntityShape} overlap each other, false otherwise.
     *         
     */
    public static boolean checkShapeCollsion(EntityShape a, EntityShape b) {
        var aPos = a.getPos();
        var bPos = b.getPos();

        if (aPos.getX() + a.getDimensions().getX() <= bPos.getX()
            || bPos.getX() + b.getDimensions().getX() <= aPos.getX()
            || aPos.getY() + a.getDimensions().getY() <= bPos.getY()
            || bPos.getY() + b.getDimensions().getY() <= aPos.getY()) {
            return false;
        }
        return true;
    }

    /**
     * Determine if two {@link mergeballs.utilities.EntityShape}
     * having the same Y coordinate, overlap each other.
     * @param hero
     * @param item
     * @return true if the item is picked up by the hero, false otherwise.
     */
    public static boolean checkItemPickUp(EntityShape hero, EntityShape item) {
        //System.out.println("Hero: " + hero.getPos() + "item: " + item.getPos());
        return (hero.getPos().getX() < item.getPos().getX() && checkX(hero, item)) 
                || (item.getPos().getX() < hero.getPos().getX() && checkX(item, hero));
    } 

    private static boolean checkX(EntityShape a, EntityShape b) {
        return (a.getPos().getX() + a.getDimensions().getX() >= b.getPos().getX());
    }

}