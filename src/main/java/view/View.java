package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JPanel contentPane;
    private JTextField firstPolyField;
    private JTextField secondPolyField;
    private JLabel title;
    private JLabel firstPTitle;
    private JLabel secondPTitle;
    private JButton multiplyBtn;
    private JButton divideBtn;
    private JButton addBtn;
    private JButton subtractBtn;
    private JButton derivateBtn;
    private JButton integrateBtn;
    private JButton exitBtn;


    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 476, 427);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        title = new JLabel("Polynomial Calculator");
        title.setBounds(74, 11, 319, 43);
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(title);

        firstPTitle = new JLabel("1st Polynomial");
        firstPTitle.setBounds(33, 65, 98, 29);
        firstPTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(firstPTitle);

        secondPTitle = new JLabel("2nd Polynomial");
        secondPTitle.setBounds(33, 105, 98, 29);
        secondPTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(secondPTitle);

        firstPolyField = new JTextField();
        firstPolyField.setBounds(141, 65, 276, 29);
        firstPolyField.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(firstPolyField);
        firstPolyField.setColumns(10);

        secondPolyField = new JTextField();
        secondPolyField.setBounds(141, 105, 276, 29);
        secondPolyField.setFont(new Font("Arial", Font.PLAIN, 14));
        secondPolyField.setColumns(10);
        contentPane.add(secondPolyField);

        multiplyBtn = new JButton("Multiply");
        multiplyBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        multiplyBtn.setBounds(39, 176, 179, 49);
        contentPane.add(multiplyBtn);

        divideBtn = new JButton("Divide");
        divideBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        divideBtn.setBounds(39, 231, 179, 49);
        contentPane.add(divideBtn);

        addBtn = new JButton("Add");
        addBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        addBtn.setBounds(39, 287, 179, 49);
        contentPane.add(addBtn);

        subtractBtn = new JButton("Subtract");
        subtractBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        subtractBtn.setBounds(238, 176, 179, 49);
        contentPane.add(subtractBtn);

        derivateBtn = new JButton("Derivate");
        derivateBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        derivateBtn.setBounds(238, 231, 179, 49);
        contentPane.add(derivateBtn);

        integrateBtn = new JButton("Integrate");
        integrateBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        integrateBtn.setBounds(238, 287, 179, 49);
        contentPane.add(integrateBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(361, 354, 89, 23);
        contentPane.add(exitBtn);
    }

    public String getFirstPoly() { return firstPolyField.getText(); }
    public String getSecondPoly() { return secondPolyField.getText(); }
    public void multiplyBtnListener(ActionListener e) { multiplyBtn.addActionListener(e); }
    public void divideBtnListener(ActionListener e) { divideBtn.addActionListener(e); }
    public void addBtnListener(ActionListener e) { addBtn.addActionListener(e); }
    public void subtractBtnListener(ActionListener e) { subtractBtn.addActionListener(e); }
    public void derivateBtnListener(ActionListener e) { derivateBtn.addActionListener(e); }
    public void integrateBtnListener(ActionListener e) { integrateBtn.addActionListener(e); }
    public void exitBtnListener(ActionListener e) { exitBtn.addActionListener(e); }
    public void showInfo(String info) {
        JOptionPane.showMessageDialog(this, info, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
    public void showError(String err) {
        JOptionPane.showMessageDialog(this, err, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
