public class Attacker extends Player {

    public void jogTraining() {
        System.out.println("Training stamina by jogging.");
    }

    @Override
    public void play() {
        System.out.println("Play aggressively.");
    }
}
