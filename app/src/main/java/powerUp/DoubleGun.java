package powerUp;

import pangGuy.gun.GunRaiser;

public class DoubleGun extends Thread implements PowerUp{

    private final GunRaiser gunRaiser;
    private int timeElapsed;
    private int duration;

    public DoubleGun(GunRaiser gunRaiser){
        this.gunRaiser = gunRaiser;
        this.timeElapsed = 0;
        this.duration = 15;
    }

    @Override
    public void run(){
        System.out.println("Double Gun Enabled");
        this.gunRaiser.activateSecondGun();
        while(!this.isActive()){
            try{
                System.out.print(".");
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("\nThread.sleep() Exception: " + e.getMessage());
            }
            this.timeElapsed++;
        }
            System.out.println("Finished");
            this.gunRaiser.deactivateSecondGun();
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
