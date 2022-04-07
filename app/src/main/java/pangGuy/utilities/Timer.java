package pangGuy.utilities;


import pangGuy.modularGun.Status;
import pangGuy.modularGun.Bullet;

public class Timer extends Thread{

    private final int duration;
    private long timeElapsed;
    private boolean stopV;
    private final Bullet arpion;

    public Timer(Bullet arpion){
        this.duration = arpion.getWaitTime();
        this.timeElapsed = 0;
        this.stopV = false;
        this.arpion = arpion;
    }


    @Override
    public void run(){
        while(!this.stopV){
            try{
                if(this.arpion.getStatus() == Status.HIT){
                    this.stopV = true;
                }
                Thread.sleep(1);
                this.timeElapsed += 1;
                if(this.timeElapsed == this.duration * 1000){
                    this.stopV = true;
                }
            }catch(Exception e){
                System.out.println("Thread.sleep() Exception: " + e.getMessage());
            }
        }

    }

    public boolean isActive(){
        return !this.stopV;
    }


}
