package pangGuy.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import masterControl.gui.VisualInterface;
import masterControl.gui.VisualPanelTest;
import pangGuy.utilities.Pair;
import pangGuy.modularGun.Status;
import pangGuy.utilities.Directions;
import pangGuy.utilities.EntityPos2D;

import java.awt.Toolkit;


public class Visual implements VisualInterface{
    
    private HeroComponent hero;
    private List<ArpionComponent> arpions;
    private Pair<Integer, Integer> bounds;

    private EntityPos2D startPosition;

    public Visual(EntityPos2D startPos, Pair<Integer, Integer> bounds){
        this.hero = new HeroComponent(startPos);
        this.startPosition = startPos;


        this.bounds = bounds;
        this.arpions = new ArrayList<>(List.of(
            new ArpionComponent(this.hero.getShape().getLeftFoot()),
            new ArpionComponent(this.hero.getShape().getLeftFoot()))
        );
        
    }
    
    @Override
    public void move(EntityPos2D pos){
        this.hero.changeLocation(pos);
        this.getArpions().forEach(e -> {
            if(e.getStatus() == Status.IDLE){
                e.changeLocation(pos);
            }
        });
        Toolkit.getDefaultToolkit().sync();
    }
        
    @Override
    public void setDirection(Directions dir){
        this.getArpions().forEach(e -> {
            if(e.getStatus() == Status.IDLE){
                e.setDirection(dir, this.hero.getShape());
            }
        });
    }
        
    @Override
    public HeroComponent getHeroComponent(){
        return this.hero;
    }
        
    @Override
    public List<ArpionComponent> getArpions(){
        return this.arpions;
    }
        
    @Override
    public Pair<Integer, Integer> getBounds(){
        return this.bounds;
    }
        
    @Override
    public EntityPos2D getStartPos(){
        return this.startPosition;
    }
        
    @Override
    public Optional<ArpionComponent> getFreeComponent(){
        for(ArpionComponent i : this.getArpions()){
            if(i.getStatus() == Status.IDLE){
                return Optional.of(i);
            }
        }

        return Optional.empty();

    }
        
    @Override
    public void restoreBullet(ArpionComponent bullet, EntityPos2D charPos, Directions dir){
        for(ArpionComponent i : this.getArpions()){
            if(i == bullet){
                i.changeLocation(new EntityPos2D(charPos.getX(), charPos.getY()));
                i.setStatus(Status.IDLE);
                i.setDirection(dir, this.hero.getShape());
            }
        }
    }

    /**
     * Returns the given ArpionComponent.
     * @param arpion the arpionComponent.
     * @return Optional<ArpionComponent> if it finds it, Optional.empty otherwise.
     */
    private Optional<ArpionComponent> giveMeThatArpion(ArpionComponent arpion){
        for(ArpionComponent i : this.getArpions()){
            if(i == arpion){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
        
    @Override
    public void raiseArpion(ArpionComponent arpion){
        var a = this.giveMeThatArpion(arpion);
        if(!a.isEmpty()){
            a.get().raise();
            Toolkit.getDefaultToolkit().sync();
        }        
    }

    @Override
    public VisualPanelTest getVisualTest() {
        return null;
    }
}
