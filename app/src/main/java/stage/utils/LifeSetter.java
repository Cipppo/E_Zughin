package stage.utils;

import pangGuy.character.Hero;
import stage.components.HUDPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * This class changes the life field of the HUD when the guy is hit by an enemy.
 */
public class LifeSetter extends Thread implements HUDFieldSetter{
    
    private final Hero hero;
    private final HUDPanel hud;
    private final Font font = new MainFontLoader().load();
    private final JLabel label = new JLabel();
    private int actualLifes;
    private Boolean terminated = false;

    public LifeSetter(HUDPanel hud, Hero hero){
        this.hud = hud;
        this.hero = hero;
        this.actualLifes = hero.getLifes();
    }

    /**
     * This thread is dedicated to the edit of the interested field when the life value changes.
     */
    @Override
    public void run(){
        label.setFont(this.font);
        while (!this.terminated) {
            try {
                if (this.hero.getLifes() == this.actualLifes){
                    label.setForeground(Color.white);
                    this.label.setText("LIFES: " + this.hero.getLifes());
                    this.hud.getHUDPanel()[3][3].removeAll();
                    this.hud.getHUDPanel()[3][3].add(label);
                    this.hud.validate();
                    this.hud.repaint();
                }else {
                    this.label.setText("LIFES: " + this.hero.getLifes());
                    this.label.setForeground(Color.red);
                    this.hud.getHUDPanel()[3][3].removeAll();
                    this.hud.getHUDPanel()[3][3].add(label);
                    this.hud.validate();
                    this.hud.repaint();
                    Thread.sleep(150);
                    this.actualLifes = this.hero.getLifes();
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread.sleep() Exception: " + e.getMessage());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void terminate() {
        this.terminated = true;
    }
}
