package App;
import com.debts.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main extends JFrame {
    private JLabel debtSum;
    private JTextArea debtSumText;

    private JLabel debtTerm;
    private JTextField debtTermText;

    private JLabel yearlyInterest;
    private JTextField yearlyInterestText;

    private JButton linijinisButton;
    private JButton clearButton;
    private JButton anuitetoButton;

    private JScrollPane tableDebt;
    private JTable debtTable;
    private JPanel paskolos;

    Main()
    {
        setContentPane(paskolos);
        setTitle("Paskolos");
        setSize(500, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        anuitetoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String debtSum = debtSumText.getText();
                String debtTerm = debtTermText.getText();
                String rate = yearlyInterestText.getText();
                Annuity an = new Annuity(debtSum, debtTerm, rate);
                Object[][] data = new Object[an.getPeriod()][3];
                for(int i = 0; i < an.getPeriod(); i++)
                {
                    data[i][0] = i + 1;
                    data[i][1] = an.getPayment();
                    data[i][2] = an.getPaymentArray(i);
                }
                debtTable.setModel(new DefaultTableModel(data, new String[]{"Mėnuo", "Įmoka", "Galutinis balansas"}));

            }
        });
        linijinisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String debtSum = debtSumText.getText();
                String debtTerm = debtTermText.getText();
                String rate = yearlyInterestText.getText();
                Linear ln = new Linear(debtSum, debtTerm, rate);
                Object[][] data = new Object[ln.getPeriod()][3];
                for(int i = 0; i < ln.getPeriod(); i++)
                {
                    data[i][0] = i + 1;
                    data[i][1] = ln.getPayment();
                    data[i][2] = ln.getPaymentArray(i);
                }
                debtTable.setModel(new DefaultTableModel(data, new String[]{"Mėnuo", "Įmoka", "Galutinis balansas"}));

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                debtSumText.setText("");
                debtTermText.setText("");
                yearlyInterestText.setText("");
                debtTable.setModel(new DefaultTableModel());
            }
        });
    }

    public static void main(String[] args) {

        Main myFrame = new Main();
    }
}



















import java.util.Scanner;

class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Paskola paskola1 = new Paskola();


        float men_pal = paskola1.getProcentas() / 100 / 12;
        float periodas =paskola1.getTerminas() * 12;
        double mathPower = Math.pow(1 + men_pal, periodas);


        double monthlyPayment = paskola1.getKreditas() * (men_pal * mathPower / (mathPower - 1));
        System.out.println("Reikia moketi= " + monthlyPayment);
        //kiek_liko(kreditas);
        paskola1.kiek_liko(monthlyPayment, paskola1.getTerminas());


    }





}

