package model;

public class Monomial implements Comparable{

    private double coefficient;
    private int exp;

    public Monomial(double coefficient, int exp) {
        this.coefficient = coefficient;
        this.exp = exp;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public int compareTo(Object o) {
        return ((Monomial) o).getExp() - this.exp;
    }
}
