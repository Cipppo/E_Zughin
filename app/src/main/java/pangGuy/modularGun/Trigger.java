package pangGuy.modularGun;

import pangGuy.character.Hero;
import pangGuy.gui.ArpionComponent;
import pangGuy.gui.BoundChecker;
import pangGuy.gui.Visual;

import pangGuy.utilities.Pos2D;
import pangGuy.utilities.StepsApplier;
public class Trigger extends Thread{
    
    private Bullet arpion;
    private ArpionComponent arpionComponent;
    private Visual visual;
    private BoundChecker bc;
    private StepsApplier stepConverter;
    private Hero hero;

    private boolean stop = false;

    public Trigger(Bullet arpion, ArpionComponent arpionComponent, Visual visual, BoundChecker bc, Hero hero){
        this.arpion = arpion;
        this.arpionComponent = arpionComponent;
        this.bc = bc;
        this.stepConverter = new StepsApplier(visual.getStartPos());
        this.hero = hero;
        this.visual = visual;
    }

    @Override
    public void run(){
        this.arpion.lock();
        this.arpionComponent.setStatus(this.arpion.getStatus());
        int xValue = this.stepConverter.convertHeroPosition(this.hero.getPosition()).x;
        int yvalue = this.stepConverter.covertStepPosition(this.arpion.getStepsDone());
        int maxYValue = this.visual.getBounds().getY();
        
        try{
            while(!this.stop){
                    this.arpion.raise();
                    //System.out.println(this.arpion.getStepsDone());
                    this.arpionComponent.raise();
                    
                    if(!this.bc.isExtendible(new Pos2D(xValue, maxYValue - this.stepConverter.covertStepPosition(this.arpion.getStepsDone())))){
                        this.stop = true;
                    }
                    Thread.sleep(20);
            }
            Thread.sleep(this.arpion.getWaitTime() * 1000);
            this.arpion.restore();
            this.arpion.unlock();
            //System.out.println(this.hero.getDirection());
            this.visual.restoreBullet(arpionComponent, new Pos2D(stepConverter.convertHeroPosition(this.hero.getPosition()).x, maxYValue - yvalue), this.hero.getDirection());
            
            
        }catch(Exception e){
            System.out.println("An error has occured: " + e.getMessage());
        }
    }

}
