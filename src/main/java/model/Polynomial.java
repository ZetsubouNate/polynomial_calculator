package model;

import java.util.ArrayList;
import java.util.List;

import static model.Operations.normPoly;

public class Polynomial{

    private ArrayList<Monomial> poly = new ArrayList<Monomial>();

    public Polynomial(ArrayList<Monomial> poly)  {
        this.poly = poly;
    }

    public Polynomial()  {
        this.poly = new ArrayList<Monomial>();
    }

    public ArrayList<Monomial> getPoly() {
        return poly;
    }

    public void addMonomial(Monomial monomial) {
        this.poly.add(monomial);
    }

    public void setPoly(ArrayList<Monomial> poly) {
        this.poly = poly;
    }

    public Polynomial(String p) {
        p = normPoly(p);
        String[] coexp = p.split("((?=\\+)|(?=\\-)|(x\\^))");

        for (int i = 0; i < coexp.length; i += 2) {
            poly.add(new Monomial(Double.parseDouble(coexp[i]), Integer.parseInt(coexp[i+1])));
        }
    }
}
