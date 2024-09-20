public class Goalie extends Player{

    private double bodySize = 0;

    public void setBodySize(double bodySize) {
        this.bodySize = bodySize;
    }

    public double getBodySize() {
        return bodySize;
    }

    @Override
    public void play() {
        System.out.println("Protect the goal.");
    }
}
