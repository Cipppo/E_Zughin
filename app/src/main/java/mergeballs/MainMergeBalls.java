package mergeballs;

import mergeballs.gui.ControlPanelTest;
import mergeballs.gui.GuiTest;

public class MainMergeBalls {
    public static void main(String[] args){
        GuiTest gui = new GuiTest();
        new ControlPanelTest(gui);
    }
}
