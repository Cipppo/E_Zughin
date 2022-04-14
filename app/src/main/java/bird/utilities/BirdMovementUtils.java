package bird.utilities;

import javax.swing.JPanel;

import bird.actions.BirdActionFactory;
import bird.gui.BirdActor;
import bird.gui.BirdBoundChecker;
import bird.gui.BirdMover;
import stage.utils.CenterOnDefaultScreen;
import pangGuy.utilities.Pair;

import java.awt.Toolkit;

public class BirdMovementUtils {

    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;
    private static final int HEIGHT = CenterOnDefaultScreen.center().width*3/100;;

    private static final int HUD_HEIGHT = CenterOnDefaultScreen.center().height*13/100;

    private final BirdActor actor;
    private final JPanel panel;
    private final BirdMover mover;
    private Boolean moveUp = false;

    private Boolean pause = false;
    private final BirdActionFactory actionFactory = new BirdActionFactory();
    private final BirdBoundChecker bc = new BirdBoundChecker(new Pair<Integer, Integer>(0, SIZEX),
                                    new Pair<Integer, Integer>(0, SIZEY));

    public BirdMovementUtils(BirdActor actor, JPanel panel, BirdMover mover) {
        this.actor = actor;
        this.panel = panel;
        this.mover = mover;
    }
    
    public final void moveRight() {
        this.moveUp = false;
        while(actor.getShape().getPos().x + WIDTH <= bc.getXPair().getY() - 5) {
            this.doMovement(BirdDirections.RIGHT);
            this.moveDown();
        }
        this.removeActor();
    }

    public final void moveLeft() {
        this.moveUp = false;
        while(actor.getShape().getPos().x >= bc.getXPair().getX() + 5) {
            this.doMovement(BirdDirections.LEFT);
            this.moveDown();
        }
        this.removeActor();
    }

    public final void moveDown() {
        if(actor.getShape().getPos().y + HEIGHT <= bc.getYPair().getY() - HUD_HEIGHT && !moveUp) {
            this.doMovement(BirdDirections.DOWN);
        } else {
            this.moveUp = true;
            this.doMovement(BirdDirections.UP);
        }
    }

    private final void doMovement(BirdDirections dir) {
        try {
            if(!this.pause) {
                if(dir == BirdDirections.RIGHT) {
                    this.actionFactory.getRightAction(this.mover);
                } else if(dir == BirdDirections.LEFT) {
                    this.actionFactory.getLeftAction(this.mover);
                } else if(dir == BirdDirections.DOWN) {
                    this.actionFactory.getDownAction(this.mover);
                } else if(dir == BirdDirections.UP) {
                    this.actionFactory.getUpAction(this.mover);
                }
                panel.repaint();
                Toolkit.getDefaultToolkit().sync();
                System.out.println(actor.getShape().getPos());
            }
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final void removeActor() {
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
