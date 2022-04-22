package mergeballs.control;

import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ball.controller.BallBoundChecker;
import ball.controller.IntersectionChecker;
import pangGuy.character.Hero;
import pangGuy.character.HitHandler;
import pangGuy.modularGun.Status;
import pangGuy.utilities.StepsApplier;
import ball.controller.BallRunner;
import bird.controller.BirdHandler;
import pangGuy.character.HeroStatus;
import pangGuy.modularGun.GunBag;

public class EntityHandler extends Thread {
    private final BallBoundChecker checker;
    private final UpdateableVisual frame;
    private final BallRunner ballRunner;
    private final GunBag gSet;
    private final StepsApplier stepsConv;
    private final Hero hero;
    private final BirdHandler bird;
    private boolean stop;

    
    public EntityHandler(UpdateableVisual frame, Hero hero) {
        this.stop = false;
        this.frame = frame;
        this.checker = new BallBoundChecker(this.frame.getBounds().getX(),
                                            this.frame.getBounds().getY());
        this.ballRunner = new BallRunner(2, this.checker);
        this.hero = hero;
        this.gSet = hero.getGset();
        this.stepsConv = new StepsApplier(this.frame.getStartPos());
        this.bird = new BirdHandler();
    }

    @Override
    public void run() {
        this.ballRunner.start();
        this.bird.start();
        while(!this.stop) {
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
                                .collect(Collectors.toList()), this.hero.getDirection(), this.bird.getShape());
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
                
                Thread.sleep(10);
            } catch (Exception e) {
                //Catching Thread Exceptions
            }
        }
    }

    public synchronized void terminate() {
        this.stop = true;
        this.ballRunner.terminate();
    }

    private void setHeroStatus() {
        if(this.hero.getStatus() == HeroStatus.NEUTRAL){
            Timer timer = new Timer();
            timer.schedule(new HitHandler(hero), 0);
        }
    }
    /**
     * Manca Hero e gunSet.getArpions();
     * @return
     */
    public synchronized List<Pausable> getPausable() {
        return Stream.concat(Stream.of(this.hero, this.ballRunner, this.bird), this.gSet.getArpions().stream()).collect(Collectors.toList());
    }

    public synchronized BallRunner getBallRunner() {
        return this.ballRunner;
    }



}
