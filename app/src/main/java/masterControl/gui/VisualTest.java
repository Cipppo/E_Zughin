package masterControl.gui;

import pangGuy.gui.ArpionComponent;
import pangGuy.gui.HeroComponent;

import pangGuy.modularGun.Status;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pair;
import powerUp.PowerUpEntity;

import java.util.List;

import ball.physics.SpherePos2D;
import bird.gui.BirdShape;
import bonus.BonusEntity;
import masterControl.control.UpdateableVisual;
import pangGuy.utilities.EntityPos2D;
import pangGuy.gui.Shape;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class VisualTest implements VisualInterface, UpdateableVisual{
    

    private HeroComponent hero;
    private List<ArpionComponent> arpions;
    private final Pair<Integer, Integer> bounds;
    
    private VisualPanelTest panel;

    private EntityPos2D startPos;
    //Maybe i have to give to this Hero in order to get all the possible status

    private Optional<PowerUpEntity> powerUp;
    private Optional<BonusEntity> bonus;

    public VisualTest(int width, int height, EntityPos2D startpos){
        this.bounds = new Pair<Integer,Integer>(width, height);

        this.panel = new VisualPanelTest(width, height);

        this.startPos = startpos;
        this.hero = new HeroComponent(startpos);

        this.bonus = Optional.empty();
        this.powerUp = Optional.empty();

        this.arpions = new ArrayList<>(List.of(
            new ArpionComponent(this.hero.getShape().getLeftFoot()), 
            new ArpionComponent(this.hero.getShape().getLeftFoot())
        ));

    }

    public List<ArpionComponent> getArpions(){
        return this.arpions;
    }

    public void move(EntityPos2D pos){
        this.hero.changeLocation(pos);
        this.getArpions().forEach(e -> {
            if(e.getStatus() == Status.IDLE){
                e.changeLocation(pos);
            }
        });
        Toolkit.getDefaultToolkit().sync();            
    }

    public void setDirection(Directions dir){
        this.getArpions().forEach(e -> {
            if(e.getStatus() == Status.IDLE){
                e.setDirection(dir, this.hero.getShape());
            }
        });
    }

    public HeroComponent getHeroComponent(){
        return this.hero;
    }

    public Pair<Integer, Integer> getBounds(){
        return this.bounds;
    }

    public EntityPos2D getStartPos(){
        return this.startPos;
    }

    public Optional<ArpionComponent> getFreeComponent(){
        for(ArpionComponent i : this.getArpions()){
            if(i.getStatus() == Status.IDLE){
                return Optional.of(i);
            }
        }

        return Optional.empty();

    }

    public void restoreBullet(ArpionComponent bullet, EntityPos2D charPos, Directions dir){
        for(ArpionComponent i : this.getArpions()){
            if(i == bullet){
                i.changeLocation(new EntityPos2D(charPos.getX(), charPos.getY()));
                i.setStatus(Status.IDLE);
                i.setDirection(dir, this.hero.getShape());
            }
        }
    }

    private Optional<ArpionComponent> giveMeThatArpion(ArpionComponent arpion){
        for(ArpionComponent i : this.getArpions()){
            if(i == arpion){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public void raiseArpion(ArpionComponent arpion){
        var a = this.giveMeThatArpion(arpion);
        if(!a.isEmpty()){
            a.get().raise();
            Toolkit.getDefaultToolkit().sync();
        }        
    }
    
    private List<Shape> getArpionsShapes() {
        return this.getArpions().stream().map(t -> t.getShape()).collect(Collectors.toList());
    }
    
    @Override
    public void updatePosition(List<SpherePos2D> pos, Directions dir, Optional<BirdShape> bShape){
        var shapes = this.getArpionsShapes();
        panel.updatePositions(pos, shapes, this.hero.getShape(), dir, this.arpions.get(0).gType(), bShape, this.powerUp, this.bonus);
    }

    @Override
    public HeroComponent getHero() {
        return this.hero;
    }

    public void setBonuses(Optional<PowerUpEntity> powerUp, Optional<BonusEntity> bonus) {
        this.powerUp = powerUp;
        this.bonus = bonus;
    }

    public VisualPanelTest getVisualTest(){
        return this.panel;
    }
}
