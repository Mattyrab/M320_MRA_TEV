import java.util.Scanner;

public class Menu {
    private Team team = new Team();
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("----Make your own Teams!----");
            System.out.println("1 = Add an Attacker");
            System.out.println("2 = Add your Defender");
            System.out.println("3 = Add a Goalie");
            System.out.println("4 = View your Team");
            System.out.println("5 = Exit Team Management");

            System.out.println("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAttacker();
                    break;
                case 2:
                    addDefender();
                    break;
                case 3:
                    addGoalie();
                    break;
                case 4:
                    viewTeam();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void addAttacker() {
        Attacker attacker = new Attacker();
        System.out.print("Enter Attacker's name: ");
        String name = scanner.nextLine();
        attacker.setName(name);
        team.setAttackers(attacker);
        System.out.println("Added Attacker: " + name);
    }

    private void addDefender(){
        Defender defender = new Defender();
        System.out.print("Enter Defender's name: ");
        String name = scanner.nextLine();
        defender.setName(name);
        team.setDefenders(defender);
        System.out.println("Added Defender: " + name);
    }

    private void addGoalie(){
        if (team.getGoalie() == null) {
            Goalie goalie = new Goalie();
            System.out.print("Enter Goalie's name: ");
            String name = scanner.nextLine();
            goalie.setName(name);

            System.out.print("Enter Goalie's body size: ");
            double bodySize = scanner.nextDouble();
            scanner.nextLine();
            goalie.setBody_size(bodySize);

            team.setGoalie(goalie);
            System.out.println("Added Goalie: " + name);
        } else {
            System.out.println("Goalie already exists.");
        }
    }

    private void viewTeam(){
        System.out.println("\nTeam Composition");

        System.out.println("Attackers:");
        for (Attacker attacker : team.getAttackers()) {
            System.out.println("- " + attacker.getName());
        }

        System.out.println("Defenders:");
        for (Defender defender : team.getDefenders()) {
            System.out.println("- " + defender.getName());
        }

        if (team.getGoalie() != null) {
            System.out.println("Goalie: " + team.getGoalie().getName() + " (Body Size: " + team.getGoalie().getBody_size() + ")");
        } else {
            System.out.println("No Goalie added.");
        }
    }
}
