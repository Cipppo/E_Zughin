package pangGuy.modularGun;

import java.awt.Color;


import java.util.Set;

import java.util.List;
import java.util.ArrayList;

import java.util.Optional;


import pangGuy.gui.BoundChecker;
import pangGuy.gui.Field;
import pangGuy.utilities.Directions;

public class GunSet{

    private final static long WAIT = 2000;

    private final List<Bullet> arpions;
    

    private GunTypes currentGun;

    public GunSet(){
        this.arpions = new ArrayList<Bullet>(
            Set.of(new Arpion(), new Arpion())
        );

        this.setDirections(Directions.LEFT);

        this.currentGun = GunTypes.ARPION;
    }

    private Optional<Bullet> getSingleArpion(){
        if(this.currentGun == GunTypes.ARPION || this.currentGun == GunTypes.STICKY_ARPION){
            if(this.arpions.get(0).getStatus() == Status.IDLE){
                return Optional.of(this.arpions.get(0));
            }else{
                return Optional.empty();
            }
        }else if(this.currentGun == GunTypes.DOUBLE_ARPION){
            for(Bullet i : this.arpions){
                if(i.getStatus() == Status.IDLE){
                    return Optional.of(i);
                }
            }
        }
        return Optional.empty();
    }

    public void setGunType(GunTypes type){
        this.currentGun = type;
    }

    public void resetGunType(GunTypes caller){
        if(caller == this.currentGun){
            this.currentGun = GunTypes.ARPION;
        }
    }


    private Optional<Bullet> getShootingGun(){
        Optional<Bullet> shootingGun = Optional.empty();
    
        if(!this.getSingleArpion().isEmpty()){
            shootingGun = getSingleArpion();
        }
    
        return shootingGun;       
    }


    public void setDirections(Directions dir){
        for(Bullet i : this.arpions){
            i.changeDir(dir);
            
        }
    }

    public List<Bullet> getArpions(){
        return this.arpions;
    }

    /*
    public void shoot(){
        var shootingGun = this.getShootingGun();
        if(!shootingGun.isEmpty()){
            if(this.currentGun == GunTypes.STICKY_ARPION){
                new Trigger(shootingGun.get(), bc, WAIT).start();
            }else{
                new Trigger(shootingGun.get(), bc, 0).start();
            }
        }else{
            System.out.println("There are no usable guns!");
        }
    }
    */
    
}
