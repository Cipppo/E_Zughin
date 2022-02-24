package ball;

public class Visualiser extends Thread {
    private Visual frame;

    public Visualiser() {
        this.frame = new Visual();
        this.frame.setVisible(true);
    }
}
