public class Konto {
    private int kontoNr;
    private double saldo;


    public Konto(int kontoNr) {
        this.kontoNr = kontoNr;
        this.saldo = 100.0;
    }

    public int getKontoNr() {
        return kontoNr;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setKontoNr(int kontoNr) {
        this.kontoNr = kontoNr;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void einzahlen(double betrag){
        if(betrag > 0){
            saldo -= betrag;
            System.out.println("Es wurden" + betrag + "auf Ihrem Konto eingezahlt." );
        }else{
            System.out.println("Einzahlungsbetrag muss positiv sein");
        }
    }
    public void abheben(double betrag) {
        if (betrag > 0 && saldo >= betrag) {
            saldo -= betrag;
            System.out.println("Es wurden " + betrag + " von Konto " + kontoNr + " abgehoben.");
        } else if (betrag > saldo) {
            System.out.println("Nicht genügend Guthaben auf Konto " + kontoNr + ".");
        } else {
            System.out.println("Abhebungsbetrag muss positiv sein.");
        }
    }

    public void ueberweisen(Konto nachKonto, double betrag) {
        if (betrag > 0 && saldo >= betrag) {
            this.abheben(betrag);
            nachKonto.einzahlen(betrag);
            System.out.println("Es wurden " + betrag + " von Konto " + this.kontoNr + " auf Konto " + nachKonto.getKontoNr() + " überwiesen.");
        } else {
            System.out.println("Überweisung nicht möglich. Überprüfen sie ihr Konto und schauen sie ihren Kontostand");
        }
    }



}


