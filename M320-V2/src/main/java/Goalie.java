public class Goalie extends Player{

    private double body_size = 0;

    public void setBody_size(double body_size) {
        this.body_size = body_size;
    }

    public double getBody_size() {
        return body_size;
    }

    public void play() {
        System.out.println("Protect the goal.");
    }
}
