package pangGuy.character;

import java.util.TimerTask;

/**
 * Models a TimerTask used to set the Hero status to NEUTRAL after certain time.
 */

public class hitCondition extends TimerTask{

    private heroStatus status;

    
    public hitCondition(heroStatus status){
        this.status = status;
    }

    @Override
    public void run() {
        this.status = heroStatus.NEUTRAL;
        System.out.println(this.status);
    }
    
}
