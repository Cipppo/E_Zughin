package ball.gui;

import ball.ballAgent.BallAgent;

/**
 * This makes the BallAgent communicate with the Visual
 */
public class Visualiser extends Thread {
    private final Visual frame;
    private final BallAgent agent;

    public Visualiser() {
        this.frame = new Visual();
        this.frame.setVisible(true);
        this.agent = new BallAgent();
    }


    @Override
    public void run() {
        try {
            this.agent.start();
            while(true) {
                this.frame.updatePosition(this.agent.getBallPosition());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
