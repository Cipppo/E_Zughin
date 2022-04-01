package pangGuy.modularGun;

import pangGuy.gui.BoundChecker;


public class Trigger extends Thread{
    
    private final Bullet bullet;
    private final BoundChecker bc;

    public Trigger(Bullet bullet, BoundChecker bc){
        this.bullet = bullet;
        this.bc = bc;
    }

    @Override
    public void run(){
        try{
            this.bullet.setUnMovable();
            while(this.bc.isExtendible(this.bullet.getPos())){
                this.bullet.raise();
                Thread.sleep(20);
            }
            this.bullet.restore();
            this.bullet.setMovable();
        }catch(Exception e){
            System.out.println("An error occured: " + e.getMessage());
        }
    }

}
