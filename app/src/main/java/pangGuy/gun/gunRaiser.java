package pangGuy.gun;

import pangGuy.gui.BoundChecker;

public class gunRaiser{

    private final Gun gun;
    private final BoundChecker bc;



    public gunRaiser(Gun gun, BoundChecker bc){
        this.gun = gun;
        this.bc = bc;
    }

    public void raise(){
        if(this.gun.getMovable()){
            new Raiser(gun, bc).start();
        }else{
            System.out.println("Impossible to perform");
        }
    }

}