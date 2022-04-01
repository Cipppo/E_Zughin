package pangGuy.modularGun;

import java.awt.Color;


import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import java.util.Optional;

import pangGuy.gui.Actor;
import pangGuy.gui.BoundChecker;
import pangGuy.gui.Field;

public class GunSet{

    private final List<Bullet> arpions;
    //private final Bullet gun; TODO after gun implementation
    private final Actor actor;
    private GunTypes currentGun;
    private final BoundChecker bc;

    public GunSet(Actor actor, Field field){
        this.arpions = new ArrayList<Bullet>(
            Set.of(new Arpion(actor, Color.green), new Arpion(actor, Color.RED))
        );

        this.bc = new BoundChecker(field.getSizeX(), field.getSizeY());
        this.actor = actor;
        this.currentGun = GunTypes.ARPION;
    }

    private Optional<Bullet> getSingleArpion(){
        if(this.currentGun == GunTypes.ARPION){
            if(this.arpions.get(0).isMovable()){
                return Optional.of(this.arpions.get(0));
            }else{
                return Optional.empty();
            }
        }else if(this.currentGun == GunTypes.DOUBLE_ARPION){
            for(Bullet i : this.arpions){
                if(i.isMovable()){
                    return Optional.of(i);
                }
            }
        }
        return Optional.empty();
    }

    public void setGunType(GunTypes type){
        this.currentGun = type;
    }


    private Optional<Bullet> getShootingGun(){
        Optional<Bullet> shootingGun = Optional.empty();
        if(this.currentGun == GunTypes.ARPION || this.currentGun == GunTypes.DOUBLE_ARPION){
            if(!this.getSingleArpion().isEmpty()){
                shootingGun = getSingleArpion();
            }
        }
        return shootingGun;       
    }


    public void moveGuns(){
        if(this.currentGun == GunTypes.ARPION || this.currentGun == GunTypes.DOUBLE_ARPION){
            for(Bullet i : this.arpions){
                i.setPos(this.actor.getShape().getPos());
                i.changeDir(this.actor.getDir());
                
            }
        }
    }

    public List<Bullet> getArpions(){
        return this.arpions;
    }

    public void shoot(){
        var shootingGun = this.getShootingGun();
        if(!shootingGun.isEmpty()){
            new Trigger(shootingGun.get(), bc).start();
        }else{
            System.out.println("There are no usable guns!");
        }
    }
    
}
