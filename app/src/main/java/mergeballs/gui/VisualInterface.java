package mergeballs.gui;

import pangGuy.gui.HeroComponent;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;

import java.util.List;
import java.util.Optional;

import pangGuy.gui.ArpionComponent;

public interface VisualInterface {
    
    void move(Pos2D pos);
    void setDirection(Directions dir);
    HeroComponent getHeroComponent();
    List<ArpionComponent> getArpions();
    Pair<Integer, Integer> getBounds();
    Pos2D getStartPos();
    Optional<ArpionComponent> getFreeComponent();
    void restoreBullet(ArpionComponent bullet, Pos2D charPos, Directions dir);
    void raiseArpion(ArpionComponent arpion);
    public VisualPanelTest getVisualTest();
}
