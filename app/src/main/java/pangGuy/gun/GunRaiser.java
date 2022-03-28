package pangGuy.gun;

import pangGuy.gui.BoundChecker;

public class GunRaiser{

    private final Gun gun1;
    private final Gun gun2;
    private boolean isSecondActive;
    private final BoundChecker bc;



    public GunRaiser(Gun gun, Gun gun2, BoundChecker bc){
        this.gun1 = gun;
        this.gun2 = gun2;
        this.bc = bc;
        this.isSecondActive = false;
    }

    public void raise(){
        if(this.gun1.getMovable()){
            new Raiser(gun1, bc).start();
        }else if(!this.gun1.getMovable() && this.gun2.getMovable() && this.isSecondActive){
            new Raiser(gun2, bc).start();
        }else{
            System.out.println("Impossible to perform");
        }
    }

    public void activateSecondGun(){
        this.isSecondActive = true;
    }

    public void deactivateSecondGun(){
        this.isSecondActive = false;
    }
}