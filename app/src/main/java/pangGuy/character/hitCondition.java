package pangGuy.character;

import java.util.TimerTask;

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
