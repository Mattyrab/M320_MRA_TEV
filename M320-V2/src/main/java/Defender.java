/**
 * <p>Subclass of Player</p>
 * <p>Plays defensively and prevent attackers of opposite team from getting goals</p>
 * @author Matthew & Tristan
 */
public class Defender extends Player {

    /**
     * <p>Describes the style of play by the player, defensive for Defenders</p>
     * <p>Prints style out in the console</p>
     */
    @Override
    public void play() {
        System.out.println("Play defensively.");
    }


}
