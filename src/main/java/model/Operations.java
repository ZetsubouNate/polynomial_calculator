package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operations {
    public static String normPoly(String p) {
        p = p.replace(" ", "");
        p = p.replace("+x", "+1x");
        p = p.replace("x+", "x^1+");
        p = p.replace("-x", "-1x");
        p = p.replace("x-", "x^1-");
        if (p.charAt(p.length() - 1) == 'x')
            p = p + "^1";
        if (p.charAt(0) == 'x')
            p = "1" + p;

        int ok = 0;
        int i = p.length();
        while (i != 0) {
            if (p.charAt(i - 1) == 'x') {
                ok = 1;
                break;
            }
            if (p.charAt(i - 1) == '+' || p.charAt(i - 1) == '-')
                break;
            i--;
        }

        if (ok == 0)
            p = p + "x^0";

        return p;
    }

    public static boolean inputCheck(String p) {

        if (p.equals(""))
            return false;

        p = normPoly(p);
        String[] coexp = p.split("((?=\\+)|(?=\\-)|(x\\^))");
        for (String s : coexp) {
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static String resultString(Polynomial p) {
        String result = "";

        int okZero = 1;
        for (int i = 0; i < p.getPoly().size(); i++) {
            if (p.getPoly().get(i).getCoefficient() != 0) {
                okZero = 0;
                break;
            }
        }

        if (okZero == 1)
            result = "0";
        else {
            for (Monomial m : p.getPoly()) {
                DecimalFormat df = new DecimalFormat("#.##");
                if (m.getCoefficient() > 0) {
                    String rounded = df.format(m.getCoefficient());
                    result += " + " + rounded + "x^" + m.getExp();
                } else if (m.getCoefficient() < 0) {
                    String rounded = df.format(-1 * m.getCoefficient());
                    result += " - " + rounded + "x^" + m.getExp();
                }
            }

            result = result.replace("1x", "x");
            result = result.replace("x^1", "x");
            result = result.replace("x^0", "");

            if (result.charAt(1) == '+')
                result = result.substring(3);
        }

        return result;
    }

    public static Polynomial addSubtractPoly(Polynomial p1, Polynomial p2, int op) {
        int i = 0, j = 0;
        Polynomial result = new Polynomial();
        while (i < p1.getPoly().size() && j < p2.getPoly().size()) {
            if (p1.getPoly().get(i).getExp() == p2.getPoly().get(j).getExp()) {
                result.addMonomial(new Monomial(p1.getPoly().get(i).getCoefficient() + op * p2.getPoly().get(j).getCoefficient(), p1.getPoly().get(i).getExp()));
                i++;
                j++;
            } else if (p1.getPoly().get(i).getExp() < p2.getPoly().get(j).getExp()) {
                result.addMonomial(new Monomial(op * p2.getPoly().get(j).getCoefficient(), p2.getPoly().get(j).getExp()));
                j++;
            } else {
                result.addMonomial(new Monomial(p1.getPoly().get(i).getCoefficient(), p1.getPoly().get(i).getExp()));
                i++;
            }
        }
        if (i != 0) {
            for (int m = i; m < p1.getPoly().size(); m++)
                result.addMonomial(new Monomial(p1.getPoly().get(m).getCoefficient(), p1.getPoly().get(m).getExp()));
        }
        if (j != 0) {
            for (int m = j; m < p2.getPoly().size(); m++)
                result.addMonomial(new Monomial(op * p2.getPoly().get(m).getCoefficient(), p2.getPoly().get(m).getExp()));
        }
        return result;
    }

    public static Polynomial multiplyPoly(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Monomial m1 : p1.getPoly()) {
            for (Monomial m2 : p2.getPoly()) {
                result.addMonomial(new Monomial(m1.getCoefficient() * m2.getCoefficient(), m1.getExp() + m2.getExp()));
            }
        }
        Collections.sort(result.getPoly());
        int exp = result.getPoly().get(0).getExp();
        double cSum = 0;
        Polynomial result2 = new Polynomial();
        for (Monomial m : result.getPoly()) {
            if (exp == m.getExp()) {
                cSum += m.getCoefficient();
            } else {
                result2.addMonomial(new Monomial(cSum, exp));
                exp = m.getExp();
                cSum = m.getCoefficient();
                if (m.getExp() == result.getPoly().get(result.getPoly().size() - 1).getExp()) {
                    result2.addMonomial(new Monomial(cSum, exp));
                }
            }
        }
        return result2;
    }

    public static void swapPoly(Polynomial p1, Polynomial p2) {
        Polynomial p = p1;
        p1 = p2;
        p2 = p;
    }

    public static Division dividePoly(Polynomial p1, Polynomial p2) {
        Division result = new Division();
        if (p1.getPoly().get(0).getExp() < p2.getPoly().get(0).getExp()) {
            swapPoly(p1, p2);
        }
        if (p2.getPoly().get(0).getCoefficient() == 0) {
            return null;
        }
        result.setRemainder(p1);
        Polynomial temp = new Polynomial();
        int i = 0;
        while (p2.getPoly().get(0).getExp() <= result.getRemainder().getPoly().get(i).getExp() && !result.getRemainder().getPoly().isEmpty()) {
            Monomial mona = new Monomial(result.getRemainder().getPoly().get(i).getCoefficient() / p2.getPoly().get(0).getCoefficient(),
                    result.getRemainder().getPoly().get(i).getExp() - p2.getPoly().get(0).getExp());
            result.getQuotient().addMonomial(mona);
            temp = new Polynomial();
            temp.addMonomial(mona);
            temp = new Polynomial(multiplyPoly(temp, p2).getPoly());
            result.getRemainder().setPoly(addSubtractPoly(result.getRemainder(), temp, -1).getPoly());
            i++;
        }
        return result;
    }

    public static Polynomial derivatePoly(Polynomial p) {
        Polynomial result = new Polynomial();

        for (Monomial m : p.getPoly()) {
            result.addMonomial(new Monomial(m.getCoefficient() * m.getExp(), m.getExp() - 1));
        }
        return result;
    }

    public static Polynomial integratePoly(Polynomial p) {
        Polynomial result = new Polynomial();

        for (Monomial m : p.getPoly()) {
            result.addMonomial(new Monomial(m.getCoefficient() / (m.getExp() + 1), m.getExp() + 1));
        }
        return result;
    }

}
