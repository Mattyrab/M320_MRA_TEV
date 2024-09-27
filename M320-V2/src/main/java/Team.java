import java.util.ArrayList;

/**
 * Represents a team consisting of attackers, defenders, and a goalie.
 */
public class Team {

    private ArrayList<Attacker> attackers = new ArrayList<>();
    private ArrayList<Defender> defenders = new ArrayList<>();
    private Goalie goalie;

    /**
     * Adds an attacker to the team, if there are fewer than 16 attackers.
     *
     * @param attacker The attacker to be added.
     */
    public void setAttackers(Attacker attacker) {
        if (attackers.size() < 16) {
            this.attackers.add(attacker);
        } else {
            System.out.println("No space left.");
        }
    }

    /**
     * Gets the list of attackers on the team.
     *
     * @return The list of attackers.
     */
    public ArrayList<Attacker> getAttackers() {
        return attackers;
    }

    /**
     * Adds a defender to the team, if there are fewer than 4 defenders.
     *
     * @param defender The defender to be added.
     */
    public void setDefenders(Defender defender) {
        if (defenders.size() < 4) {
            this.defenders.add(defender);
        } else {
            System.out.println("No space left.");
        }
    }

    /**
     * Gets the list of defenders on the team.
     *
     * @return The list of defenders.
     */
    public ArrayList<Defender> getDefenders() {
        return defenders;
    }

    /**
     * Sets the goalie for the team.
     *
     * @param goalie The goalie to be added.
     */
    public void setGoalie(Goalie goalie) {
        this.goalie = goalie;
    }

    /**
     * Gets the goalie of the team.
     *
     * @return The goalie.
     */
    public Goalie getGoalie() {
        return goalie;
    }
}
