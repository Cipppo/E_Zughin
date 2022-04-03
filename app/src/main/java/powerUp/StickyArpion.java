package powerUp;

import pangGuy.modularGun.GunSet;
import pangGuy.modularGun.GunTypes;

public class StickyArpion extends Thread implements PowerUp{

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
        while(!this.isActive()){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("\nThread.sleep() Exception: " + e.getMessage());
            }
            this.timeElapsed++;
        }
        System.out.println("Sticky Arpion: Finished");
        this.gSet.setGunType(GunTypes.ARPION);
        this.timeElapsed = 0;
    }



    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean isActive() {
        return this.timeElapsed == this.duration;
    }
    
    
}
