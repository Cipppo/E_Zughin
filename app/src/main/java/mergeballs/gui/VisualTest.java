package mergeballs.gui;

import pangGuy.gui.ArpionComponent;
import pangGuy.gui.HeroComponent;
import pangGuy.gui.PangGuyImageLoader;
import pangGuy.modularGun.Status;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;

import java.util.List;

import ball.gui.ImageLoader;
import ball.physics.SpherePos2D;
import mergeballs.control.UpdateableVisual;
import pangGuy.gui.Shape;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class VisualTest implements VisualInterface, UpdateableVisual{
    

    private HeroComponent hero;
    private List<ArpionComponent> arpions;
    private final Pair<Integer, Integer> bounds;
    
    private VisualPanelTest panel;
    private ImageLoader iLoader;
    private PangGuyImageLoader heroILoader;

    private Pos2D startPos;

    public VisualTest(int width, int height, Pos2D startpos){
        this.bounds = new Pair<Integer,Integer>(width, height);

        this.iLoader = new ImageLoader();
        this.heroILoader = new PangGuyImageLoader();
        this.panel = new VisualPanelTest(width, height, iLoader, heroILoader);

        this.startPos = startpos;
        this.hero = new HeroComponent(startpos);

        this.arpions = new ArrayList<>(List.of(
            new ArpionComponent(Color.red, this.hero.getShape().getLeftFoot()), 
            new ArpionComponent(Color.green, this.hero.getShape().getLeftFoot())
        ));

    }

    public List<ArpionComponent> getArpions(){
        return this.arpions;
    }

    public void move(Pos2D pos){
        this.hero.changeLocation(pos);
        this.getArpions().forEach(e -> {
            if(e.getStatus() == Status.IDLE){
                e.setLocation(this.hero.getShape().getPos().x, this.hero.getShape().getPos().y);
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

    public Pos2D getStartPos(){
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

    public void restoreBullet(ArpionComponent bullet, Pos2D charPos, Directions dir){
        for(ArpionComponent i : this.getArpions()){
            if(i == bullet){
                i.changeLocation(new Pos2D(charPos.x, charPos.y));
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
    public void updatePosition(List<SpherePos2D> pos){
        var shapes = this.getArpionsShapes();
        panel.updatePositions(pos, shapes, this.hero.getShape());
    }

    public VisualPanelTest getVisualTest(){
        return this.panel;
    }
}
