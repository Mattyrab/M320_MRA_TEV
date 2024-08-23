public class Konto {
    private int kontoNr;
    private int saldo;


    public Konto(int kontoNr) {
        this.kontoNr = kontoNr;
        this.saldo = 10000;
    }

    public int getKontoNr() {
        return kontoNr;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setKontoNr(int kontoNr) {
        this.kontoNr = kontoNr;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    private String printBetrag(int betrag) {
        String betragStr = String.valueOf(betrag);
        return new StringBuilder(betragStr).insert(betragStr.length()-2, ".").toString();
    }

    public void einzahlen(int betrag){
        if(betrag > 0){
            saldo += betrag;
            System.out.println("Es wurden " + printBetrag(betrag) + " auf Ihrem Konto eingezahlt." );
        }else{
            System.out.println("Einzahlungsbetrag muss positiv sein");
        }
    }
    public void abheben(int betrag) {
        if (betrag > 0 && saldo >= betrag) {
            saldo -= betrag;
            System.out.println("Es wurden " + printBetrag(betrag) + " von Konto " + kontoNr + " abgehoben.");
        } else if (betrag > saldo) {
            System.out.println("Nicht genügend Guthaben auf Konto " + kontoNr + ".");
        } else {
            System.out.println("Abhebungsbetrag muss positiv sein.");
        }
    }

    public void ueberweisen(Konto nachKonto, int betrag) {
        if (betrag > 0 && saldo >= betrag) {
            this.abheben(betrag);
            nachKonto.einzahlen(betrag);
            System.out.println("Es wurden " + printBetrag(betrag) + " von Konto " + this.kontoNr + " auf Konto " + nachKonto.getKontoNr() + " überwiesen.");
        } else {
            System.out.println("Überweisung nicht möglich. Überprüfen sie ihr Konto und schauen sie ihren Kontostand");
        }
    }



}


