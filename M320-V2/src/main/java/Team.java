import java.util.ArrayList;

public class Team {

    private ArrayList<Attacker> attackers = new ArrayList<>();
    private ArrayList<Defender> defenders = new ArrayList<>();
    private Goalie goalie;

    public void setAttackers(Attacker attacker) {
        if (attackers.size() < 16) {
            this.attackers.add(attacker);
        }
        else {
            System.out.println("No space left.");
        }
    }

    public ArrayList<Attacker> getAttackers() {
        return attackers;
    }

    public void setDefenders(Defender defender) {
        if (defenders.size() < 4) {
            this.defenders.add(defender);
        }
        else {
            System.out.println("No space left.");
        }
    }

    public ArrayList<Defender> getDefenders() {
        return defenders;
    }

    public void setGoalie(Goalie goalie) {
        this.goalie = goalie;
    }

    public Goalie getGoalie() {
        return goalie;
    }
}
