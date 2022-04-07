package bird.utilities;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import bird.gui.Actor;
import bird.gui.BoundChecker;
import bird.gui.Mover;
import bird.gui.Shape;
import stage.utils.CenterOnDefaultScreen;
import stage.components.MainPanel;

public class MoveBird extends Thread{

    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;
    private static final int HEIGHT = CenterOnDefaultScreen.center().width*3/100;;

    private static final int STARTY = 0;

    private Shape shape;

    private final MainPanel panel;
    private BoundChecker bc = new BoundChecker(new Pair<Integer>(0, SIZEX),
                                    new Pair<Integer>(0, SIZEY));
    private Mover mover;
    private Actor actor;
    private int startX;
    private final Random random = new Random();
    private Directions dir;
    private Boolean pause = false;
    private MovementUtils movUtils;

    public MoveBird(MainPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void run() {
        while(!pause) {
            
            this.dir = this.randomDirectionChooser();
            this.startX = this.dir == Directions.RIGHT ? 0 : SIZEX - WIDTH;
            this.shape = new Shape(new Pos2D(startX, STARTY), WIDTH, HEIGHT, Optional.of(dir));
            this.actor = new Actor(this.shape);
            this.mover = new Mover(this.actor, bc);
            movUtils = new MovementUtils(actor, panel, mover);

            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10) + 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.add(this.actor);
            panel.repaint();
            if(startX == 0) {
                movUtils.moveRight();
            } else if(startX == SIZEX - WIDTH) {
                movUtils.moveLeft();
            }
        }
    }

    public Directions randomDirectionChooser() {
        if(random.nextInt(2) == 0) {
            return Directions.RIGHT;
        } else {
            return Directions.LEFT;
        }
    }

    public Actor getActor() {
        return this.actor;
    }

    public int getStartX() {
        return this.startX;
    }

    public void setPause() {
        movUtils.setPause();
    }
}
