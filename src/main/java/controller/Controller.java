package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Division;
import model.Operations;
import model.Polynomial;
import view.View;

public class Controller {

    View view;

    public Controller(View view) {
        this.view = view;
        view.setVisible(true);

        view.exitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        view.addBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Operations.inputCheck(view.getFirstPoly()) && Operations.inputCheck(view.getSecondPoly())) {
                    Polynomial p1 = new Polynomial(view.getFirstPoly());
                    Polynomial p2 = new Polynomial(view.getSecondPoly());
                    Polynomial result = Operations.addSubtractPoly(p1, p2, 1);
                    view.showInfo(Operations.resultString(result));
                }
                else
                    view.showError("Wrong input!");
            }
        });

        view.subtractBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Operations.inputCheck(view.getFirstPoly()) && Operations.inputCheck(view.getSecondPoly())) {
                    Polynomial p1 = new Polynomial(view.getFirstPoly());
                    Polynomial p2 = new Polynomial(view.getSecondPoly());
                    Polynomial result = Operations.addSubtractPoly(p1, p2, -1);
                    view.showInfo(Operations.resultString(result));
                }
                else
                    view.showError("Wrong input!");
            }
        });

        view.multiplyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Operations.inputCheck(view.getFirstPoly()) && Operations.inputCheck(view.getSecondPoly())) {
                    Polynomial p1 = new Polynomial(view.getFirstPoly());
                    Polynomial p2 = new Polynomial(view.getSecondPoly());
                    Polynomial result = Operations.multiplyPoly(p1, p2);
                    view.showInfo(Operations.resultString(result));
                }
                else
                    view.showError("Wrong input!");
            }
        });

        view.divideBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Operations.inputCheck(view.getFirstPoly()) && Operations.inputCheck(view.getSecondPoly())) {
                    Polynomial p1 = new Polynomial(view.getFirstPoly());
                    Polynomial p2 = new Polynomial(view.getSecondPoly());
                    Division result = Operations.dividePoly(p1, p2);
                    view.showInfo("Quotient: " + Operations.resultString( result.getQuotient()) + "\n" + "Remainder: " +  Operations.resultString( result.getRemainder()));
                }
                else
                    view.showError("Wrong input!");
            }
        });

        view.derivateBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Operations.inputCheck(view.getFirstPoly())) {
                    Polynomial p = new Polynomial(view.getFirstPoly());
                    Polynomial result = Operations.derivatePoly(p);
                    view.showInfo(Operations.resultString(result));
                }
                else
                    view.showError("Wrong input!");
            }
        });

        view.integrateBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Operations.inputCheck(view.getFirstPoly())) {
                    Polynomial p = new Polynomial(view.getFirstPoly());
                    Polynomial result = Operations.integratePoly(p);
                    view.showInfo(Operations.resultString(result));
                }
                else
                    view.showError("Wrong input!");
            }
        });
    }
}
