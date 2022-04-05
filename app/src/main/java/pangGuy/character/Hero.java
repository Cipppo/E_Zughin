package pangGuy.character;

import pangGuy.modularGun.GunSet;
import pangGuy.modularGun.Status;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;

public class Hero {
    
    private Pos2D pos;
    private Directions direction;
    private GunSet gSet;
    private Telemetry telemetry;

    public Hero(){
        this.pos = new Pos2D(0, 0);
        this.direction = Directions.LEFT;
        this.gSet = new GunSet();
        this.telemetry = new Telemetry();
    }

    private void updateDirection(Directions dir){
        this.direction = dir;
        this.gSet.setDirections(dir);
    }

    public Directions getDirection(){
        return this.direction;
    }

    public Pos2D getPosition(){
        return this.pos;
    }

    public void move(Directions dir){
        switch (dir) {
            case RIGHT:
                this.pos = new Pos2D(pos.x + 1, pos.y);
                break;
            case LEFT:
                this.pos = new Pos2D(pos.x - 1, pos.y);
                break;
            default:
                this.updateDirection(dir);
        }
    }

    public void shoot(){
        var gun = this.gSet.getShootingGun();
        if(!gun.isEmpty()){
            gun.get().setStatus(Status.RISING);
            this.telemetry.startShoot(gun.get());
        }
    }

    //Whatever, Timer is counting the steps done not the time Elapsed
    //Probaly gonna need a refactor 
    public Telemetry getTelemetry(){
        return this.telemetry;
    }

}
