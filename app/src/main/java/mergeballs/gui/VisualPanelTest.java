package mergeballs.gui;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.awt.CardLayout;

import java.util.List;
import java.util.Optional;

import ball.gui.ImageLoader;
import ball.physics.SpherePos2D;
import bird.gui.BirdShape;
import bird.utilities.BirdPNGLoader;
import bonus.BonusEntity;
import bonus.BonusImageLoader;
import mergeballs.utilities.BackgroundImageLoader;
import pangGuy.gui.ArpionImageLoader;
import pangGuy.gui.PangGuyImageLoader;
import pangGuy.gui.Shape;
import pangGuy.modularGun.GunTypes;
import pangGuy.utilities.Directions;
import powerUp.PowerUpEntity;
import powerUp.PowerupImageLoader;

@SuppressWarnings("unused")
public class VisualPanelTest extends JPanel {

    private List<SpherePos2D> ballPositions;
    private List<Shape> shapes;
    private Shape hShape;
    private Optional<BirdShape> bShape;
    private Directions dir;
    private GunTypes gunType;
    private final int width;
    private final int height;
    private final ImageLoader iLoader;
    private final ArpionImageLoader aILoader;
    private final PangGuyImageLoader heroILoader;
    private final PowerupImageLoader pUpImageLoader;
    private final BirdPNGLoader birdPNGLoader;
    private final BonusImageLoader bonusILoader;
    private final BackgroundImageLoader backLoader;
    private Optional<PowerUpEntity> pUp;
    private Optional<BonusEntity> bonus;


    public VisualPanelTest(int width, int height, ImageLoader iLoader, PangGuyImageLoader heroILoader, ArpionImageLoader aILoader, PowerupImageLoader pIl, BirdPNGLoader birdPNGLoader) {
        super.setSize(width, height);
        this.width = width;
        this.height = height;
        this.iLoader = iLoader;
        this.heroILoader = heroILoader;
        this.aILoader = aILoader;
        this.pUpImageLoader = pIl;
        this.birdPNGLoader = birdPNGLoader;
        this.bonusILoader = new BonusImageLoader();
        this.backLoader = new BackgroundImageLoader();
        this.setLayout(new CardLayout());
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, this.width, this.height);

        synchronized(this) {
            g2.drawImage(backLoader.getBackImage(), 0, 0, this.width, this.height, this);

            if (this.ballPositions != null) {
                for (final var position : ballPositions) {
                    int x = (int)(position.getX() * this.width);
                    int y = (int)(position.getY() * this.height);
                    g2.drawImage(iLoader.getBallImage(position.getDimension()), x, y, this);
                }
            }
            if (this.shapes != null) {
                for (final var shape : shapes) {
                    g2.drawImage(this.aILoader.getArpionSprites(this.gunType).get(0), shape.getPos().getX(), shape.getPos().getY(), this);
                }
            }
            if (this.hShape != null) {
                g2.drawImage(heroILoader.getHeroImage(this.dir).get(0), this.hShape.getPos().getX(), this.hShape.getPos().getY(), this);
            }
            if(!this.pUp.isEmpty()){
                g2.drawImage(pUpImageLoader.getPowUpSprite(this.pUp.get().getPowerUp()).get(), this.pUp.get().getShape().getPos().getX(), this.pUp.get().getShape().getPos().getY(), this);
                //System.out.println("x" + pUp.get().getShape().getPos().x + "y" + pUp.get().getShape().getPos().x);
            }
            if(!this.bShape.isEmpty()) {
                g2.drawImage(birdPNGLoader.getBirdImage(this.bShape.get().getDireciton(), this.bShape.get().getPos()), 
                            this.bShape.get().getPos().getX(), 
                            this.bShape.get().getPos().getY(), 
                            this);
            }
            if (!this.bonus.isEmpty()) {
                g2.drawImage(this.bonusILoader.getSprite(bonus.get()), this.bonus.get().getShape().getPos().getX(), this.bonus.get().getShape().getPos().getY(), this);
            }
        }
        g2.dispose();
        Toolkit.getDefaultToolkit().sync();
    }

    public void updatePositions(List<SpherePos2D> pos, List<Shape> aShapes, Shape hShape, Directions dir, GunTypes type, Optional<PowerUpEntity> pUp, Optional<BirdShape> bShape, Optional<BonusEntity> bonus) {
        ballPositions = pos;
        shapes = aShapes;
        this.hShape = hShape;
        this.dir = dir;
        this.gunType = type;
        this.pUp = pUp;
        this.bShape = bShape;
        this.bonus = bonus;
        repaint();
    }

}
