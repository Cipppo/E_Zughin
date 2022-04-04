package bird.gui;

import javax.swing.JFrame;

import bird.actions.ActionFactory;
import bird.utilities.MoveBird;
import stage.utils.CenterOnDefaultScreen;

public class Gui extends JFrame{

    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;

    public final ActionFactory actionFactory = new ActionFactory();

    public final MoveBird moveBird = new MoveBird(this);

    public Gui() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(SIZEX, SIZEY);
        this.getContentPane().setLayout(null);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);  
        
        moveBird.run();
    }
}
