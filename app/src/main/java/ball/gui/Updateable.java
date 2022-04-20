package ball.gui;

import ball.physics.SpherePos2D;
import pangGuy.gui.Shape;

import java.util.List;
import java.awt.Dimension;

public interface Updateable {
    /**
     * Needed to be used from the view, thanks to this
     * any visual framework only needs to implemnts this.
     * @param pos
     */
    void updatePosition(List<SpherePos2D> pos);

    Dimension getSize();

    //only for testing purposes
    Shape getGuy();
}
