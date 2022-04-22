package powerUp;

import ball.controller.BallRunner;

/**
 * TimeFreeze implements {@link powerUp.PowerUp}, and this item
 * freeze/stop all the balls in the current game for 5 seconds. 
 * When {@link pangGuy.character.Hero} hits a frozen ball, the two children 
 * ball will not be affected by this powerup.
 */
public class TimeFreeze extends Thread implements PowerUp {
    private int duration;
    private int timeElapsed;
    private boolean isActivated;
    private final BallRunner context;
    
    public TimeFreeze(BallRunner context) {
        this.isActivated = false;
        this.timeElapsed = 0;
        this.context = context;
        this.duration = 5; //default value
    }

    @Override
    public boolean isActive() {
        return this.isActivated;
    }

    @Override
    public void run() {
        this.context.pauseAll();
        System.out.println("sleeping...");
        while(!this.isRunning()) {
            try {
                System.out.print(".");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Thread.sleep Exception: " + e.getMessage());
            }
            this.timeElapsed++;
        }
        System.out.println("");
        System.out.println("finished");
        this.context.resumeAll();
    }

    private boolean isRunning() {
        return this.duration == this.timeElapsed;
    }

    @Override
    public void activate() {
        this.start();
    }
}

