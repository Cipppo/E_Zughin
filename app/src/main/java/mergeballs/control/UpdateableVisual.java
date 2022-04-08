package mergeballs.control;

import java.util.List;

import ball.physics.SpherePos2D;
import pangGuy.gui.Shape;
import pangGuy.utilities.Pair;

public interface UpdateableVisual {
    List<Shape> getArpionsShapes();
    
    void updatePosition(List<SpherePos2D> pos);

    Pair<Integer, Integer> getBounds();
}
