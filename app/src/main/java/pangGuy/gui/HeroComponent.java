package pangGuy.gui;


import pangGuy.utilities.Pos2D;

/**
 * This class models a character in the space and keeps track of his position
 * in the space.
 */

public class HeroComponent {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 50;

    private Shape s;

    /**
     * Create a new HeroComponent (with predetermined WIDTH and HEIGHT) 
     * given the startPosition in the GUI.
     * @param startPos
     */
    public HeroComponent(Pos2D startPos){
        this.s = new Shape(startPos, WIDTH, HEIGHT);

    }

    /**
     * By giving an EntityPosition, it updates the EntityShape.
     * @param pos
     */
    public void changeLocation(Pos2D pos){
        this.s = new Shape(pos, WIDTH, HEIGHT);

    }

    /**
     * Getter for the EntityShape.
     * @return the actual EntityShape.
     */
    public Shape getShape(){
        return this.s;
    }


}