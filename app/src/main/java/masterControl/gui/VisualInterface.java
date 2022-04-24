package masterControl.gui;

import pangGuy.gui.HeroComponent;
import pangGuy.utilities.Directions;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;

import java.util.List;
import java.util.Optional;

import pangGuy.gui.ArpionComponent;

public interface VisualInterface {
    /**
     * Moves the components in the GUI.
     * @param pos the position where the components are moved.
     */
    void move(EntityPos2D pos);

    /**
     * Sets the direction of the arpions, so they can move in the right way.
     * @param dir the direction where the are going to lay.
     */
    void setDirection(Directions dir);
    
    /**
     * Getter for the HeroComponent
     * @return the HeroComponent.
     */
    HeroComponent getHeroComponent();

    /**
     * Getter for the ArpionComponents.
     * @return a List of ArpionComponents.
     */
    List<ArpionComponent> getArpions();

    /**
     * Getter for the GUI bounds.
     * @return a Pair with the GUI bounds inside.
     */
    Pair<Integer, Integer> getBounds();

    /**
     * Getter for the GUI start position of the HeroComponent.
     * @return the coords of the start position of the component.
     */
    EntityPos2D getStartPos();

    /**
     * Getter for an ArpionComponent.
     * @return {@link java.util.Optional} of a {@link pangGuy.gui.ArpionComponent}
     *          if there is one not busy, Optional.empty otherwhise.
     */
    Optional<ArpionComponent> getFreeComponent();

    /**
     * Restores the Arpion from the MAXY position to his normal position.
     * @param bullet the Arpion which is going to be restored.
     * @param charPos the coords of the main Character.
     * @param dir the Direction of the main character.
     */
    void restoreBullet(ArpionComponent bullet, EntityPos2D charPos, Directions dir);

    /**
     * Tells the given ArpionComponent to raise.
     * @param arpion the arpion which needs to be raised.
     */
    void raiseArpion(ArpionComponent arpion);

    /**
     * Getter for the panel in order to add it on the main GUI.
     * @return the panel in which the characters are painted.
     */
    public VisualPanelTest getVisualTest();
}
