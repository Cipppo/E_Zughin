package pangGuy.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pangGuy.utilities.Pos2D;
import pangGuy.utilities.Pair;
import pangGuy.modularGun.Status;
import pangGuy.utilities.Directions;



public class Visual {
    
    private HeroComponent hero;
    private List<ArpionComponent> arpions;
    private Pair<Integer, Integer> bounds;

    private Pos2D startPosition;

    public Visual(Pos2D startPos, Pair<Integer, Integer> bounds){
        this.hero = new HeroComponent(startPos);
        this.startPosition = startPos;


        this.bounds = bounds;
        this.arpions = new ArrayList<>(List.of(
            new ArpionComponent(Color.red, this.hero.getShape().getLeftFoot()),
            new ArpionComponent(Color.green, this.hero.getShape().getLeftFoot()))
        );
        
    }

    public void move(Pos2D pos){
        this.hero.changeLocation(pos);
        this.getArpions().forEach(e -> {
            if(e.getStatus() == Status.IDLE){
                e.setLocation(this.hero.getShape().getPos().x, this.hero.getShape().getPos().y);
            }
        });
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

    public List<ArpionComponent> getArpions(){
        return this.arpions;
    }

    public Pair<Integer, Integer> getBounds(){
        return this.bounds;
    }

    public Pos2D getStartPos(){
        return this.startPosition;
    }

    public Optional<ArpionComponent> getFreeComponent(){
        for(ArpionComponent i : this.getArpions()){
            if(i.getStatus() == Status.IDLE){
                return Optional.of(i);
            }
        }

        return Optional.empty();

    }

    public void restoreBullet(ArpionComponent bullet, Pos2D charPos, Directions dir){
        for(ArpionComponent i : this.getArpions()){
            if(i == bullet){
                i.changeLocation(new Pos2D(charPos.x, charPos.y));
                i.setStatus(Status.IDLE);
                i.setDirection(dir, this.hero.getShape());
            }
        }
    }

    
}
