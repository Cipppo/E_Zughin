package powerUp;


import pangGuy.modularGun.GunBag;
import pangGuy.modularGun.GunTypes;

public class DoubleGun extends Thread implements PowerUp{

    private final GunBag gSet;
    private int timeElapsed;
    private int duration;

    public DoubleGun(GunBag gSet){
        this.gSet = gSet;
        this.timeElapsed = 0;
        this.duration = 15;
    }

    @Override
    public void run(){
        System.out.println("Double Gun: Active");
        this.gSet.setGunType(GunTypes.DOUBLE_ARPION);
        while(!this.isActive()){
            try{
                //System.out.print(".");
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("\nThread.sleep() Exception: " + e.getMessage());
            }
            this.timeElapsed++;
        }
            System.out.println("Double Gun: Finished");
            this.gSet.resetGunType(GunTypes.DOUBLE_ARPION);
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
