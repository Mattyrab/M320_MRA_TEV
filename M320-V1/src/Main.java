import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Direktor("Seymour Skinner"));
        people.add(new Lehrer("Walter White"));
        people.add(new Sekretaerin("Pam Beesly"));
        people.add(new Sozialarbeiter("Michael Scott"));
        people.add(new Schueler("Jesse Pinkman"));

        for (Person person : people){
            System.out.println(person.getName());
        }
    }
}