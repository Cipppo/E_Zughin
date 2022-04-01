package powerUp;


import pangGuy.modularGun.GunSet;
import pangGuy.modularGun.GunTypes;
public class DoubleGun extends Thread implements PowerUp{

    private final GunSet gSet;
    private int timeElapsed;
    private int duration;

    public DoubleGun(GunSet gSet){
        this.gSet = gSet;
        this.timeElapsed = 0;
        this.duration = 15;
    }

    @Override
    public void run(){
        System.out.println("Double Gun Enabled");
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
            System.out.println("Finished");
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
