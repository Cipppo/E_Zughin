package bird.controller;

import ball.utils.Pair;
import bird.gui.BirdActor;
import bird.gui.BirdShape;
import pangGuy.gui.Shape;

public class BirdConstraintCheck {

    /**
     * Checks wether the bird hits a {@link pangGuy.gui.Shape} or not.
     * 
     * @param entity
     *          rectangular shaped entity
     * @param bird 
     *          bird shaped entity
     * @return
     *          true if the two enemies collides
     */
    public boolean checkEnemyCollision(Shape entity, BirdActor bird) {
        return isCollision(bird.getShape(), entity);
    }

    private boolean isCollision(BirdShape bird, Shape rect) {
        var rectWidht = rect.getDimensions().getX();
        var rectHeight = rect.getDimensions().getY();
        Pair<Integer> rectCenter = new Pair<Integer>(rect.getPos().x + (int)(0.5*rectWidht),
                                                    rect.getPos().y + (int)(0.5*rectHeight));
        Pair<Integer> birdCenter = new Pair<Integer>(bird.getPos().x + (bird.getDimensions().getX() / 2),
                                                    bird.getPos().y + (bird.getDimensions().getY() / 2));
        Pair<Integer> birdDistance = new Pair<Integer>(0, 0);

        birdDistance.setX(Math.abs(birdCenter.getX() - rectCenter.getY()));
        birdDistance.setY(Math.abs(birdCenter.getY() - rectCenter.getY()));

        if(birdDistance.getX() > (rectWidht / + bird.getDimensions().getX() / 2)) {
            return false;
        }

        if(birdDistance.getY() > (rectHeight / 2 + bird.getDimensions().getY() / 2)) {
            return false;
        }

        if(birdDistance.getX() <= (rectWidht / 2) || birdDistance.getY() <= (rectHeight / 2)) {
            return true;
        }

        return false;
    }
}
