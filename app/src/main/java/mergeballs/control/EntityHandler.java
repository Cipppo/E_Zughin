package mergeballs.control;

import java.util.Timer;
import java.util.stream.Collectors;

import ball.controller.BallBoundChecker;
import ball.controller.IntersectionChecker;
import mergeballs.gui.VisualTest;
import pangGuy.character.Hero;
import pangGuy.character.HitHandler;
import pangGuy.modularGun.GunSet;
import pangGuy.modularGun.Status;
import pangGuy.utilities.StepsApplier;
import powerUp.PowerUpHandler;
import ball.controller.Runner;
import bird.controller.BirdHandler;
import bonus.BonusHandler;
import bonus.Score;
import pangGuy.character.HeroStatus;

public class EntityHandler extends Thread {
    private final BallBoundChecker checker;
    private final UpdateableVisual frame;
    private final Runner ballRunner;
    private final GunSet gSet;
    private final StepsApplier stepsConv;
    private final Hero hero;
    private final Score score;
    private final PowerUpHandler pUpHandler;
    private final BonusHandler bonHandler;
    private final BirdHandler bird;
    private Boolean pauseEntity = false;

    
    public EntityHandler(VisualTest frame, GunSet gSet, Hero hero, Score score) {
        this.frame = frame;
        this.checker = new BallBoundChecker(this.frame.getBounds().getX(),
                                            this.frame.getBounds().getY());
        this.ballRunner = new Runner(2, this.checker);
        this.hero = hero;
        this.gSet = gSet;
        this.stepsConv = new StepsApplier(this.frame.getStartPos());
        this.pUpHandler = new PowerUpHandler(gSet, this.ballRunner, this.frame.getBounds());
        this.bonHandler = new BonusHandler(this.frame.getBounds());
        this.bird = new BirdHandler();
        this.score = score;
    }

    @Override
    public void run() {
        this.ballRunner.start();
        this.pUpHandler.start();
        this.bonHandler.start();
        this.bird.start();
        while(true) {
            try {
                ballRunner.getBalls()
                .forEach(t -> {
                    for (final var arp : frame.getArpions()) {
                        if (arp.getStatus().equals(Status.RISING)) {
                            if (this.checker.checkEnemyCollision(arp.getShape(), t)) {
                                this.gSet.getBulletFromSteps(this.stepsConv.fromPixeltoStep(arp.getShape().getPos().getY())).get().hit();
                                this.ballRunner.duplication(t);
                            } 
                        }
                    }

                    if (this.checker.checkEnemyCollision(this.frame.getHero().getShape(), t)) {
                        this.setHeroStatus();
                    }

                    this.frame.updatePosition(this.ballRunner
                                .getBalls()
                                .stream()
                                .map(s -> s.getBallPosition())
                                .collect(Collectors.toList()), this.hero.getDirection(), this.pUpHandler.getPowerup(), this.bird.getShape(), this.bonHandler.getBonus());
                });

                if (!this.bird.getActor().isEmpty()) {
                    for (final var arp : frame.getArpions()) {
                        if (arp.getStatus().equals(Status.RISING)) {
                            if (IntersectionChecker.checkShapeCollsion(arp.getShape(), this.bird.getShape().get())) {
                                this.gSet.getBulletFromSteps(this.stepsConv.fromPixeltoStep(arp.getShape().getPos().getY())).get().hit();
                                this.bird.setBirdDead();
                            }
                        }
                    }

                    if (IntersectionChecker.checkShapeCollsion(this.bird.getShape().get(), this.frame.getHero().getShape())) {
                        this.setHeroStatus();
                    }
                }

                if (!this.pUpHandler.getPowerup().isEmpty()) {
                    this.pUpHandler.checkItemTaken(this.frame.getHero());
                }

                if(!this.bonHandler.getBonus().isEmpty()){
                    var points = this.bonHandler.getBonus().get().getPoints();
                    if (this.bonHandler.checkItemTaken(this.frame.getHero())) {
                        this.score.raiseScore(points);
                        System.out.println(this.score.toString());
                    }
                }
                
                Thread.sleep(10);
            } catch (Exception e) {
                //Catching Thread Exceptions
            }
        }
    }

    //temp
    public Boolean getPauseStatus() {
        return this.pauseEntity;
    }

    //temp
    public void setPause() {
        this.pauseEntity = !this.pauseEntity;
    }

    private void setHeroStatus() {
        if(this.hero.getStatus() == HeroStatus.NEUTRAL){
            Timer timer = new Timer();
            timer.schedule(new HitHandler(hero), 0);
        }
    } 
}
