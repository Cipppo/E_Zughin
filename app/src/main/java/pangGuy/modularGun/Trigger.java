package pangGuy.modularGun;

import pangGuy.gui.BoundChecker;


public class Trigger extends Thread{
    
    //private final Bullet bullet;
    //private final BoundChecker bc;
    //private final  long waitTime;

    public Trigger(Bullet bullet, BoundChecker bc, long waitTime){
        //this.bullet = bullet;
        //this.bc = bc;
        //this.waitTime = waitTime;
    }

    @Override
    public void run(){
        /*
        try{
            this.bullet.setStatus(Status.RISING);
            while(this.bc.isExtendible(this.bullet.getPos())){
                this.bullet.raise();
                Thread.sleep(20);
            }
            Thread.sleep(this.waitTime);
            this.bullet.restore();
            this.bullet.setMovable();
        }catch(Exception e){
            System.out.println("An error occured: " + e.getMessage());
        }
        */
    }

}
