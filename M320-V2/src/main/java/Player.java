/**
 * <p>Player Class</p>
 * <p>Each player has a name and can do the base action of playing the game</p>
 *
 * @author Matthew Tristan
 */
public class Player {

    /**
     * <p>Player name (uses String class)</p>
     */
    private String name;

    /**
     * <p>Setter method for name of Player</p>
     *
     * @param name <p> name of Player as a String</p>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter method for name of Player</p>
     *
     * @return name <p> name of Player as String</p>
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Describes the style of play by the player, default is just playing the game</p>
     * <p>Prints play style out in the console</p>
     */
    public void play() {
        System.out.println("Play the game.");
    }
}
