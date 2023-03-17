package model;

public class Division {
    private Polynomial quotient = new Polynomial();
    private Polynomial remainder = new Polynomial();


    public Polynomial getQuotient() {
        return quotient;
    }

    public void setQuotient(Polynomial quotient) {
        this.quotient = quotient;
    }

    public Polynomial getRemainder() {
        return remainder;
    }

    public void setRemainder(Polynomial remainder) {
        this.remainder = remainder;
    }




}
