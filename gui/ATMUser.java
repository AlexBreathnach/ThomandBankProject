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
                JOptionPane.showMessageDialog(root, "Deposit Account selected");
            }
        });
        btncurrentAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(root, "Current Account selected");
            }
        });
        btnCheckBal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    atmController.checkBalance(textField1.getText());
                }
            }
        });
        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    atmController.withdraw(textField1.getText());
                }
            }
        });
        btnDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    atmController.deposit(textField1.getText());
                }
            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(root, "Logging out...");
            }
        });
    }

    private boolean validateInput() {
        String input = textField1.getText();
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(root, "Account ID cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(root, "Account ID must be a number.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public JPanel getRootPanel() {
        return root;
    }
}
