package pangGuy.utilities;

public class Timer extends Thread{

    private final int duration;
    private int timeElapsed;

    public Timer(int duration){
        this.duration = duration;
        this.timeElapsed = 0;
    }


    @Override
    public void run(){
        while(!this.isActive()){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("Thread.sleep() Exception: " + e.getMessage());
            }
            this.timeElapsed++;
        }
    }


    public boolean isActive(){
        return this.timeElapsed == this.duration;
    }

    public void stopTimer(){
        this.timeElapsed = duration;
    }
    
}
