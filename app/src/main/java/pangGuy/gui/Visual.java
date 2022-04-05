package pangGuy.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import pangGuy.utilities.Pos2D;


public class Visual {
    
    private HeroComponent hero;
    private List<ArpionComponent> arpions;

    public Visual(Pos2D startPos){
        this.hero = new HeroComponent(startPos);
        
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


}
