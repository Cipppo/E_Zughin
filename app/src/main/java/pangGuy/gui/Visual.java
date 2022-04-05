package pangGuy.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import pangGuy.utilities.Pos2D;
import pangGuy.utilities.Pair;
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
            e.setLocation(this.hero.getShape().getPos().x, this.hero.getShape().getPos().y);
        });
    }

    public void setDirection(Directions dir){
        this.getArpions().forEach(e -> {
            e.setDirection(dir, this.hero.getShape());
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



    
}
