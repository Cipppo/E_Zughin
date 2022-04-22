package pangGuy.modularGun;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import pangGuy.utilities.Directions;


/**Models a set of two guns, where the second one is usable only if
 * DoubleArpion powerup is picked up.
 */

public class GunSet implements GunBag{

    private final List<Bullet> arpions;
    private GunTypes currentGun;

    /**
     * Creates a new GunSet with default values.
     */
    public GunSet(){
        this.arpions = new ArrayList<Bullet>(
            Set.of(new Arpion(), new Arpion())
        );
        this.currentGun = GunTypes.ARPION;
    }
    
    /**
     * Gives an arpion checking the current powerup in action.
     * @return Optional<Bullet> if there is a free gun, Optional.empty() otherwise.
     */
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


    @Override
    public void setGunType(GunTypes type){
        this.currentGun = type;
    }


    @Override
    public void resetGunType(GunTypes caller){
        if(caller == this.currentGun){
            this.currentGun = GunTypes.ARPION;
        }
    }

    @Override
    public Optional<Bullet> getShootingGun(){
        Optional<Bullet> shootingGun = Optional.empty();
    
        if(!this.getSingleArpion().isEmpty()){
            shootingGun = getSingleArpion();
        }
    
        return shootingGun;       
    }

    @Override
    public void setDirections(Directions dir){
        for(Bullet i : this.arpions){
            i.changeDir(dir);
            
        }
    }

    @Override
    public List<Bullet> getArpions(){
        return this.arpions;
    }

    @Override
    public void setWaitTime(int wait){
        this.getArpions().forEach(e -> {
            e.setWaitTime(wait);
        });
    }

    @Override
    public Optional<Bullet> getBulletFromSteps(int steps){
        for(Bullet i : this.arpions){
            if(i.getStepsDone() == steps){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    @Override
    public GunTypes getGunType(){
        return this.currentGun;
    }
    
}
