package pauseMenu.components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import stage.components.TimerLabel;

public class PauseButton {

    private boolean pause = false;
    private int coolDownTimer;
    
    public PauseButton(JPanel mainPanel, JPanel pausePanel, TimerLabel timer) {

        KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        mainPanel.getInputMap().put(escKey, "Esc");
        mainPanel.getActionMap().put("Esc", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!pause){
                    pausePanel.setVisible(true);
                    timer.getTimer().stop();
                    pause = true;
                } else {
                    pausePanel.setVisible(false);
                    coolDown();
                    timer.getTimer().start();
                    pause = false;
                }
            }
        });
    }

    private void coolDown() {
        coolDownTimer = 3;
        while(coolDownTimer != 0) {
            System.out.println(coolDownTimer);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            coolDownTimer--;
        }
    }
    
}
