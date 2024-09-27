/**
 * <p>Subclass of Player</p>
 * <p>Plays aggressively and attempts to get goals</p>
 * <p>Also trains to improve stamina</p>
 *
 * @author Matthew & Tristan
 */
public class Attacker extends Player {

    /**
     * <p>Gets the training of attacker players</p>
     * <p>Prints jog training out in the console</p>
     */
    public void jogTraining() {
        System.out.println("Training stamina by jogging.");
    }

    /**
     * <p>Gets the style of play by the player, aggressive for Attackers</p>
     * <p>Prints style out in the console</p>
     */
    @Override
    public void play() {
        System.out.println("Play aggressively.");
    }
}
