package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.atmController;

public class ATMUser {
    private JPanel root;
    private JButton btnDeposit;
    private JButton btnLogout;
    private JButton btnCheckBal;
    private JButton btnWithdraw;
    private JTextField textField1;
    private JRadioButton btnDepositAcc;
    private JRadioButton btncurrentAcc;

    public ATMUser() {
        btnDepositAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atmController.deposit(textField1.getText())
            }
        });
        btncurrentAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Current Account selected");

            }
        });
        btnCheckBal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atmController.checkBalance(textField1.getText())
            }
        });
        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atmController.withdraw(textField1.getText())
            }
        });
        btnDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Deposit Account selected");

            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Logging out...");
                // Optional: switch panels or exit
            }
        });

        public JPanel getRootPanel(){
            return root;
        }
    }
}

