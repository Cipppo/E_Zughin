package pangGuy.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import pangGuy.utilities.Pos2D;
import pangGuy.utilities.Pair;


public class Visual {
    
    private HeroComponent hero;
    private List<ArpionComponent> arpions;
    private Pair<Integer, Integer> bounds;

    public Visual(Pos2D startPos, Pair<Integer, Integer> bounds){
        this.hero = new HeroComponent(startPos);
        
        this.bounds = bounds;
        this.arpions = new ArrayList<>(List.of(
            new ArpionComponent(Color.red, this.hero.getShape().getLeftFoot()),
            new ArpionComponent(Color.green, this.hero.getShape().getLeftFoot()))
        );
        
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
}
