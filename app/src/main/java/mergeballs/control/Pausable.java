package mergeballs.control;

/**
 * This interface models two components of the behaviour of 
 * an active controller, meaning that, a class that implements
 * this methods, will be able to be stopped or resumed if stopped.
 * The type wrapped by this interface is used by {@link mergeballs.control.PauseHandler}.
 */
public interface Pausable {

    /**
     * Pauses the all the Entities contained in this controller.
     */
    public void pauseAll();

    /**
     * Resumes the all the Entities contained in this controller.
     */
    public void resumeAll();
    
}
