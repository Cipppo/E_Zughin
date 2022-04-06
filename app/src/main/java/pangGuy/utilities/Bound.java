package pangGuy.utilities;

import java.util.Optional;



public class Bound {
    
    private Optional<Integer> serialNumber;


    public Bound(){
        this.serialNumber = Optional.empty();
    }

    public void bound(int serialNumber){
        this.serialNumber = Optional.of(serialNumber);
    }

    public void unBound(){
        this.serialNumber = Optional.empty();
    }

    public boolean isBound(){
        if(this.serialNumber.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public int getBound(){
        if(this.isBound()){
            return this.serialNumber.get();
        }else{
            return 0;
        }
    }
}
