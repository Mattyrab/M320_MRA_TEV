/**
 * <p>Subclass of Player</p>
 * <p>Protects the goal from opposite team attackers</p>
 * <p>Also has a body size</p>
 *
 * @author Matthew & Tristan
 */
public class Goalie extends Player{

    /**
     * <p>Describes the body size of the Goalie as a double</p>
     */
    private double bodySize = 0;

    /**
     * <p>Setter method for bodySize of Goalie</p>
     *
     * @param bodySize <p> bodySize of Goalie as a double</p>
     */
    public void setBodySize(double bodySize) {
        this.bodySize = bodySize;
    }

    /**
     * <p>Getter method for bodySize of Goalie</p>
     *
     * @return bodySize <p> bodySize of Goalie as a double</p>
     */
    public double getBodySize() {
        return bodySize;
    }

    /**
     * <p>Describes the style of play by the player, protective for Goalie</p>
     * <p>Prints style out in the console</p>
     */
    @Override
    public void play() {
        System.out.println("Protect the goal.");
    }
}
