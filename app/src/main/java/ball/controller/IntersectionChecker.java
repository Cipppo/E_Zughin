package ball.controller;

import ball.physics.SpherePos2D;
import ball.utils.Pair;
import pangGuy.gui.Shape;

public class IntersectionChecker {
	
    public static boolean isBallCollision(SpherePos2D ball, Shape rect) {
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

    public static boolean checkShapeCollsion(Shape a, Shape b) {
        var aBottomLeft = new Pair<Integer>(a.getPos().x, a.getPos().y + a.getDimensions().getY());
        var aTopRight = new Pair<Integer>(a.getPos().x + a.getDimensions().getX(), a.getPos().y);

        var bBottomLeft = new Pair<Integer>(b.getPos().x, b.getPos().y + b.getDimensions().getY());
        var bTopRight = new Pair<Integer>(b.getPos().x + b.getDimensions().getX(), b.getPos().y);
 
        return (aBottomLeft.getX() < bTopRight.getX()) 
            && (bBottomLeft.getX() < aTopRight.getX()) 
            && (aBottomLeft.getY() < bTopRight.getY()) 
            && (bBottomLeft.getY() < aTopRight.getY());
    }

    public static boolean checkItemPickUp(Shape hero, Shape item) {
        System.out.println("Hero: " + hero.getPos() + "item: " + item.getPos());
        return (hero.getPos().x < item.getPos().x && checkX(hero, item)) 
                || (item.getPos().x < hero.getPos().x && checkX(item, hero));
    } 

    private static boolean checkX(Shape a, Shape b) {
        return (a.getPos().x + a.getDimensions().getX() >= b.getPos().x);
    }

}