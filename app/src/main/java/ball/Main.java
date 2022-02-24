package ball;

import ball.gui.Visual;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Visual view = new Visual();
        view.setVisible(true);
        while(true) {
            ball.updatePos();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.updatePosition(ball.getCurrentPosition());
        }
    }
}
