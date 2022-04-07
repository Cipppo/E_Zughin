package mergeballs.gui;

//import java.awt.BorderLayout;

import javax.swing.JFrame;

import stage.utils.*;
//import stage.components.*;

public class GuiTest extends JFrame{


    private final int width = CenterOnDefaultScreen.center().width*70/100;
    private final int height = CenterOnDefaultScreen.center().height*70/100;


    public GuiTest(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setLayout(null);
        this.setVisible(true);
    }



    
}
