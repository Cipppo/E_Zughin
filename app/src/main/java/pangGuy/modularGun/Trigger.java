package pangGuy.modularGun;

import pangGuy.character.Hero;
import pangGuy.gui.ArpionComponent;
import pangGuy.gui.BoundChecker;
import pangGuy.gui.Visual;
import mergeballs.gui.VisualInterface;
import pangGuy.utilities.Pos2D;
import pangGuy.utilities.StepsApplier;

public class Trigger extends Thread{
    
    private Bullet arpion;
    private ArpionComponent arpionComponent;
    private VisualInterface visual;
    private BoundChecker bc;
    private StepsApplier stepConverter;
    private Hero hero;

    private boolean stop = false;

    public Trigger(Bullet arpion, ArpionComponent arpionComponent, VisualInterface visual, BoundChecker bc, Hero hero){
        this.arpion = arpion;
        this.arpionComponent = arpionComponent;
        this.bc = bc;
        this.stepConverter = new StepsApplier(visual.getStartPos());
        this.hero = hero;
        this.visual = visual;
    }

    @Override
    public void run(){
        int xValue = this.stepConverter.convertHeroPosition(this.hero.getPosition()).x;
        this.arpion.lock(xValue);
        this.arpionComponent.setStatus(this.arpion.getStatus());
        int yvalue = this.stepConverter.covertStepPosition(this.arpion.getStepsDone());
        int maxYValue = this.visual.getBounds().getY();
        
        try{
            while(!this.stop){
                    this.arpion.raise();
                    this.visual.raiseArpion(arpionComponent);
                    
                    if(!this.bc.isExtendible(new Pos2D(xValue, maxYValue - this.stepConverter.covertStepPosition(this.arpion.getStepsDone()))) || 
                            this.arpion.getStatus() == Status.HIT){
                        this.stop = true;
                    }
                    Thread.sleep(20);
            }

            if(this.arpion.getWaitTime() > 0){
                int sync = 0;
                if(this.arpion.getWaitTime() > 0){
                    while(sync <= 2000){
                        sync++;
                        if(this.arpion.getStatus() == Status.HIT){
                            break;
                        }
                        Thread.sleep(1);
                    }
                }
            }

            this.arpion.restore();
            System.out.println(this.arpion.getStatus());
            //this.arpion.unlock();
            this.visual.restoreBullet(arpionComponent, new Pos2D(stepConverter.convertHeroPosition(this.hero.getPosition()).x, maxYValue - yvalue), this.hero.getDirection());
            
            
        }catch(Exception e){
            System.out.println("An error has occured: " + e.getMessage());
        }
    }

}
