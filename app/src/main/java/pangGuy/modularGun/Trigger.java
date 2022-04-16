package pangGuy.modularGun;

import pangGuy.character.Hero;
import pangGuy.gui.ArpionComponent;
import pangGuy.gui.BoundChecker;
import mergeballs.gui.VisualInterface;
import mergeballs.utilities.EntityPos2D;
import pangGuy.utilities.StepsApplier;

/**
 * Manages the Rising of the Arpions.
 */


public class Trigger extends Thread{
    
    private Bullet arpion;
    private ArpionComponent arpionComponent;
    private VisualInterface visual;
    private BoundChecker bc;
    private StepsApplier stepConverter;
    private Hero hero;
    private boolean stop = false;

    /**
     * Creates a new Trigger.
     * @param arpion the Model of the Arpion which is going to be raised.
     * @param arpionComponent the Component of the Arpion which is gonna be raised.
     * @param visual the Visual in order to retrieve the start GUI positon.
     * @param bc the boundChecker in order to stop the arpion at a certain time.
     * @param hero the hero Model.
     */
    public Trigger(Bullet arpion, ArpionComponent arpionComponent, VisualInterface visual, BoundChecker bc, Hero hero){
        this.arpion = arpion;
        this.arpionComponent = arpionComponent;
        this.bc = bc;
        this.stepConverter = new StepsApplier(visual.getStartPos());
        this.hero = hero;
        this.visual = visual;
    }

    @Override
    /**
     * It manages the rising of the Arpion by making steps and checking if the next position is eligible.
     */
    public void run(){
        int xValue = this.stepConverter.convertHeroPosition(this.hero.getPosition()).x;
        this.arpion.lock();
        this.arpionComponent.setStatus(this.arpion.getStatus());
        this.arpionComponent.setType(this.hero.getGset().getGunType());
        int yvalue = this.stepConverter.covertStepPosition(this.arpion.getStepsDone());
        int maxYValue = this.visual.getBounds().getY();
        try{
            while(!this.stop){
                    this.arpion.raise();
                    this.visual.raiseArpion(arpionComponent);
                    if(!this.bc.isExtendible(new EntityPos2D(xValue, maxYValue - this.stepConverter.covertStepPosition(this.arpion.getStepsDone()))) || 
                            this.arpion.getStatus() == Status.HIT){
                        this.stop = true;
                    }
                    Thread.sleep(8);
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
            this.visual.restoreBullet(arpionComponent, new EntityPos2D(stepConverter.convertHeroPosition(this.hero.getPosition()).x, maxYValue - yvalue), this.hero.getDirection());
        }catch(Exception e){
            System.out.println("An error has occured: " + e.getMessage());
        }
    }

}
