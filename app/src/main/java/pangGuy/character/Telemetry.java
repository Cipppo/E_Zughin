package pangGuy.character;

import java.util.List;
import java.util.ArrayList;

import pangGuy.utilities.Pair;
import pangGuy.modularGun.Bullet;

import java.util.Optional;

public class Telemetry {
    
    private Optional<Pair<Bullet, Telemetry.Timer>> time1;
    private Optional<Pair<Bullet, Telemetry.Timer>> time2;

    public Telemetry(){
        this.time1 = Optional.empty();
        this.time2 = Optional.empty();

    }

    public void startShoot(Bullet bullet){
        var timeList = this.getTimes();
        for(var i : timeList){
            if(i.isEmpty()){
                i = Optional.of(new Pair<Bullet, Telemetry.Timer>(bullet, new Timer()));
                i.get().getY().start();
            }
        }
    }

    public List<Optional<Pair<Bullet, Telemetry.Timer>>> getTimes(){
        return new ArrayList<>(List.of(this.time1, this.time2));
    }

    public Optional<Pair<Bullet, Telemetry.Timer>> getPair(Bullet bullet){
        var timeList = this.getTimes();
        for(var i : timeList){
            if(!i.isEmpty()){
                return i;
            }
        }
        return Optional.empty();
    }

    public long getBulletTime(Bullet bullet){
        var inPair = this.getPair(bullet);
        if(!inPair.isEmpty()){
            return inPair.get().getY().getElapsedTime();
        }
        return -1;
    }


    public void deleteEntry(Bullet bullet){
        var inPair = this.getPair(bullet);
        if(inPair == this.time1){
            Timer timer = inPair.get().getY();
            timer.stopTimer();
            this.time1 = Optional.empty();
        }else if(inPair == this.time2){
            Timer timer = inPair.get().getY();
            timer.stopTimer();
            this.time2 = Optional.empty();
        }
        
    }




    private class Timer extends Thread{

        private boolean stop;
        private long actual;
        

        public Timer(){
            this.stop = false;
            this.actual = 0;
        }

        @Override
        public void run(){
            try{
                while(!this.stop){
                    this.actual++;
                    Thread.sleep(20);
                }
            }catch(Exception e){
                System.out.println("An error has occured: " + e.getMessage());                
            }
        }


        public void stopTimer(){
            this.stop = true;
        }

        public long getElapsedTime(){
            return this.actual;
        }


    }

}
