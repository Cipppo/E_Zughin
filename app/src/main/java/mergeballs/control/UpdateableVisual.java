package mergeballs.control;

import java.util.List;

import ball.physics.SpherePos2D;
import pangGuy.gui.ArpionComponent;
import pangGuy.gui.Shape;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;

public interface UpdateableVisual {
    List<Shape> getArpionsShapes();
    
    void updatePosition(List<SpherePos2D> pos);

    Pair<Integer, Integer> getBounds();

    //Temporary
    List<ArpionComponent> getArpions();

    Pos2D getStartPos();
}
