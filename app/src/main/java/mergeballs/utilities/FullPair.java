package mergeballs.utilities;

/**
 * Models a Pair class usable to store pair (X,Y) of a data couple.
 */


public interface FullPair<T, E> {
    
    /**
     * Getter for X param
     * @return the left member of the pair.
     */
    T getX();

    /**
     * Getter for Y param
     * @return the right member of the pair. 
     */
    E getY();

}
