

public class Main {
    public static void main(String[] args) {

        Konto primaryKonto = new Konto(1234);

        primaryKonto.einzahlen(1200);

        System.out.println( primaryKonto.getSaldo());

        primaryKonto.abheben(11300);

        primaryKonto.abheben(1300);


    }
}