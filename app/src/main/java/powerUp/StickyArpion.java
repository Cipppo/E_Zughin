package powerUp;

import pangGuy.modularGun.GunSet;
import pangGuy.modularGun.GunTypes;

public class StickyArpion extends Thread implements PowerUp{

    private final static int WAIT_SECONDS = 2;

    private final GunSet gSet;
    private int timeElapsed;
    private int duration;

    public StickyArpion(GunSet gSet){
        this.gSet = gSet;
        this.timeElapsed = 0;
        this.duration = 15;
    }

    @Override
    public void run(){
        System.out.println("Sticky Arpion: Active");
        this.gSet.setGunType(GunTypes.STICKY_ARPION);
        this.gSet.setWaitTime(WAIT_SECONDS);
        while(!this.isActive()){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("\nThread.sleep() Exception: " + e.getMessage());
            }
            this.timeElapsed++;
        }
        this.gSet.resetWaitTime();
        System.out.println("Sticky Arpion: Finished");
        this.gSet.resetGunType(GunTypes.STICKY_ARPION);
        this.timeElapsed = 0;
    }

    @Override
    public boolean isActive() {
        return this.timeElapsed == this.duration;
    }
    
    @Override
    public void activate() {
        this.start();
    }
}
