package pangGuy.modularGun;

import java.util.List;
import java.util.Optional;

import pangGuy.utilities.Directions;

public interface GunBag {
    
    /**
    * Setter for the GunType.
    * @param type the GunType which needs to be set.
    */
    void setGunType(GunTypes type);

    /**
    * Resets the GunType only if the caller is the actual gunType (Like a sort of mutex).
    * @param caller the GunType which asks to be resetted.
    */
    void resetGunType(GunTypes caller);

    /**
    * @return Optional<Bullet> if there is a gun available, Optional.empty otherwise.
    */
    Optional<Bullet> getShootingGun();

    /**
     * Sets the Arpion directions in order to lay in the right coords.
     * @param dir the Direction which needs to be set.
     */
    void setDirections(Directions dir);

    /**
     * @return a List of the two Arpions.
     */
    List<Bullet> getArpions();

    /**
     * Set the Arpions wait time between the Y_MAX point reach and restore.
     * @param wait the seconds to be wait.
     */
    void setWaitTime(int wait);

    /**
     * Given a Step number, it searches the Arpion which has made the steps.
     * @param steps the Steps which the Arpion Made.
     * @return Optional<Bullet> if it finds the arpion, Optional.empty otherwhise.
    */
    Optional<Bullet> getBulletFromSteps(int steps);
    
    /**
     * Getter fot the GunType
     * @return the current GunType
     */
    GunTypes getGunType();
}
