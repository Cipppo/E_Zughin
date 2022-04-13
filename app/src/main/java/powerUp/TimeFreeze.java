package powerUp;

import ball.controller.Runner;

/**
 * This class Models the TimeFreeze PowerUP.
 */
public class TimeFreeze extends Thread implements PowerUp {
    private int duration;
    private int timeElapsed;
    private boolean isActivated;
    private final Runner context;
    
    public TimeFreeze (Runner context) {
        this.isActivated = false;
        this.timeElapsed = 0;
        this.context = context;
        this.duration = 3; //default value
    }

    @Override
    public void setDuration(final int duration) {
        this.duration = duration;
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
}

