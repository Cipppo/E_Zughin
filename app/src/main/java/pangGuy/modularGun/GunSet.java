package pangGuy.modularGun;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import pangGuy.utilities.Directions;


/**Models a set of two guns, where the second one is usable only if
 * DoubleArpion powerup is picked up.
 */

public class GunSet{

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

    /**
     * Setter for the GunType.
     * @param type the GunType which needs to be set.
     */
    public void setGunType(GunTypes type){
        this.currentGun = type;
    }

    /**
     * Resets the GunType only if the caller is the actual gunType (Like a sort of mutex).
     * @param caller the GunType which asks to be resetted.
     */
    public void resetGunType(GunTypes caller){
        if(caller == this.currentGun){
            this.currentGun = GunTypes.ARPION;
        }
    }

    /**
     * 
     * @return Optional<Bullet> if there is a gun available, Optional.empty otherwise.
     */
    public Optional<Bullet> getShootingGun(){
        Optional<Bullet> shootingGun = Optional.empty();
    
        if(!this.getSingleArpion().isEmpty()){
            shootingGun = getSingleArpion();
        }
    
        return shootingGun;       
    }

    /**
     * Sets the Arpion directions in order to lay in the right coords.
     * @param dir the Direction which needs to be set.
     */
    public void setDirections(Directions dir){
        for(Bullet i : this.arpions){
            i.changeDir(dir);
            
        }
    }

    /**
     * 
     * @return a List of the two Arpions.
     */
    public List<Bullet> getArpions(){
        return this.arpions;
    }

    /**
     * Set the Arpions wait time between the Y_MAX point reach and restore.
     * @param wait the seconds to be wait.
     */
    public void setWaitTime(int wait){
        this.getArpions().forEach(e -> {
            e.setWaitTime(wait);
        });
    }

    /**
     * Given a Step number, it searches the Arpion which has made the steps.
     * @param steps the Steps which the Arpion Made.
     * @return Optional<Bullet> if it finds the arpion, Optional.empty otherwhise.
     */
    public Optional<Bullet> getBulletFromSteps(int steps){
        for(Bullet i : this.arpions){
            if(i.getStepsDone() == steps){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /**
     * Getter fot the GunType
     * @return the current GunType
     */
    public GunTypes getGunType(){
        return this.currentGun;
    }
    
}
