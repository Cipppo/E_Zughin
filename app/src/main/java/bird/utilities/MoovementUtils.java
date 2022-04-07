package bird.utilities;

import javax.swing.JPanel;

import bird.actions.ActionFactory;
import bird.gui.Actor;
import bird.gui.BoundChecker;
import bird.gui.Mover;
import stage.utils.CenterOnDefaultScreen;

import java.awt.Toolkit;

public class MoovementUtils {

    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;

    private final Actor actor;
    private final JPanel panel;
    private final Mover mover;

    private Boolean pause = false;
    private final ActionFactory actionFactory = new ActionFactory();
    private final BoundChecker bc = new BoundChecker(new Pair<Integer>(0, SIZEX),
                                    new Pair<Integer>(0, SIZEY));

    public MoovementUtils(Actor actor, JPanel panel, Mover mover) {
        this.actor = actor;
        this.panel = panel;
        this.mover = mover;
    }
    
    public final void moveRight() {
        while(actor.getShape().getPos().x + WIDTH <= bc.getXPair().getY() - 5) {
            this.doMovement(Directions.RIGHT);
        }
        this.removeActor();
    }

    public final void moveLeft() {
        while(actor.getShape().getPos().x >= bc.getXPair().getX() + 5 && !this.pause) {
            this.doMovement(Directions.LEFT);
        }
        this.removeActor();
    }

    private final void doMovement(Directions dir) {
        try {
            if(!this.pause) {
                if(dir == Directions.RIGHT) {
                    this.actionFactory.getRightAction(this.mover);
                } else {
                    this.actionFactory.getLeftAction(this.mover);
                }
                panel.repaint();
                Toolkit.getDefaultToolkit().sync();
                System.out.println(actor.getShape().getPos());
            } else {
                panel.repaint();
            }
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private final void removeActor() {
        panel.remove(this.actor);
        panel.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public void setPause() {
        if(this.pause) {
            this.pause = false;
        } else {
            this.pause = true;
        }
    }
}
