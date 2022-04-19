package ball.controller;

import ball.physics.SpherePos2D;
import ball.utils.Pair;
import mergeballs.utilities.EntityShape;

public class IntersectionChecker {
	
    public static boolean isBallCollision(SpherePos2D ball, EntityShape rect) {
        var rectWidht = rect.getDimensions().getX();
        var rectHeight = rect.getDimensions().getY();
        Pair<Integer> rectCenter = new Pair<Integer>(rect.getPos().getX() + (int)(0.5*rectWidht),
                                                    rect.getPos().getY() + (int)(0.5*rectHeight));
        Pair<Integer> ballCenter = new Pair<Integer>((int)(ball.getX() + (ball.getDiameter() / 2)), (int)(ball.getY() + (ball.getDiameter() / 2) ));
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

    public static boolean checkShapeCollsion(EntityShape a, EntityShape b) {
        var aBottomLeft = new Pair<Integer>(a.getPos().getX(), a.getPos().getY() + a.getDimensions().getY());
        var aTopRight = new Pair<Integer>(a.getPos().getX() + a.getDimensions().getX(), a.getPos().getY());

        var bBottomLeft = new Pair<Integer>(b.getPos().getX(), b.getPos().getY() + b.getDimensions().getY());
        var bTopRight = new Pair<Integer>(b.getPos().getX() + b.getDimensions().getX(), b.getPos().getY());
 
        return (aBottomLeft.getX() < bTopRight.getX()) 
            && (bBottomLeft.getX() < aTopRight.getX()) 
            && (aBottomLeft.getY() < bTopRight.getY()) 
            && (bBottomLeft.getY() < aTopRight.getY());
    }

    public static boolean checkItemPickUp(EntityShape hero, EntityShape item) {
        //System.out.println("Hero: " + hero.getPos() + "item: " + item.getPos());
        return (hero.getPos().getX() < item.getPos().getX() && checkX(hero, item)) 
                || (item.getPos().getX() < hero.getPos().getX() && checkX(item, hero));
    } 

    private static boolean checkX(EntityShape a, EntityShape b) {
        return (a.getPos().getX() + a.getDimensions().getX() >= b.getPos().getX());
    }

}