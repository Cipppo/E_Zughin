package pangGuy.gui;


import pangGuy.utilities.Pos2D;


public class HeroComponent {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 50;

    private Shape s;



    public HeroComponent(Pos2D startPos){
        this.s = new Shape(startPos, WIDTH, HEIGHT);

    }


    public void changeLocation(Pos2D pos){
        this.s = new Shape(pos, WIDTH, HEIGHT);

    }

    public Shape getShape(){
        return this.s;
    }


}