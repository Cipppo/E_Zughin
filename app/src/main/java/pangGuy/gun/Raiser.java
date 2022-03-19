package pangGuy.gun;

import pangGuy.gui.BoundChecker;

public class Raiser extends Thread{


    private final Gun gun;
    private final BoundChecker bc;
    

    public Raiser(Gun gun, BoundChecker bc){
        this.gun = gun;
        this.bc = bc;
    }


    @Override
    public void run(){ 
        try{
            this.gun.setUnMovable();
            while(this.bc.isExtendible(this.gun.getPos())){
                this.gun.raise();
                Thread.sleep(20);
            }
            this.gun.restore();
            this.gun.setMovable();
        }catch (Exception e){
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    
}
