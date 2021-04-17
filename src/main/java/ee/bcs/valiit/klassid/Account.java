package ee.bcs.valiit.klassid;

public class Account { //erinevad kontod sama klassiga
    String nimi; // nt Kelly jne
    public double balance; // konto hetke jääk

    public Account(String nimi, double balance) { //konstruktor
        this.nimi = nimi;
        this.balance = balance;
    }

}
