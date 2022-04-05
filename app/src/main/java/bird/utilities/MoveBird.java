package bird.utilities;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import bird.actions.ActionFactory;
import bird.gui.Actor;
import bird.gui.BoundChecker;
import bird.gui.Mover;
import bird.gui.Shape;
import stage.utils.CenterOnDefaultScreen;

public class MoveBird extends Thread{

    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;

    private static final int WIDTH = CenterOnDefaultScreen.center().width*3/100;
    private static final int HEIGHT = CenterOnDefaultScreen.center().width*3/100;;

    private static final int STARTY = 0;

    private Shape shape;

    private final JFrame frame;
    private BoundChecker bc = new BoundChecker(new Pair<Integer>(0, SIZEX),
                                    new Pair<Integer>(0, SIZEY));
    private Mover moover;
    private Actor actor;
    private int startX;
    private final Random random = new Random();
    private final ActionFactory actionFactory = new ActionFactory();
    private Directions dir;

    public MoveBird(JFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void run() {
        while(true) {

            this.dir = this.randomDirectionChooser();
            this.startX = this.dir == Directions.RIGHT ? 0 : SIZEX - WIDTH;
            this.shape = new Shape(new Pos2D(startX, STARTY), WIDTH, HEIGHT, Optional.of(dir));
            this.actor = new Actor(this.shape);
            this.moover = new Mover(this.actor, bc);

            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10) + 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.add(this.actor);
            frame.repaint();
            try {
                if(startX == 0) {
                        while(actor.getShape().getPos().x + WIDTH <= bc.getXPair().getY() - 5) {
                            this.actionFactory.getRightAction(this.moover);
                            Thread.sleep(20);
                            frame.repaint();
                            System.out.println(actor.getShape().getPos());
                        }
                        frame.remove(this.actor);
                        frame.repaint();
                    } else {
                        while(actor.getShape().getPos().x >= bc.getXPair().getX() + 5) {
                            this.actionFactory.getLeftAction(this.moover);
                            Thread.sleep(20);
                            frame.repaint();
                            System.out.println(actor.getShape().getPos());
                        }
                        frame.remove(this.actor);
                        frame.repaint();
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
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
}
