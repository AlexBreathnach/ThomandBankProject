package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.OfficerController;

public class BankOfficerPanel {
    private JPanel root;
    private JButton btnCreateAcc;
    private JButton btnChangeODLim;
    private JButton btnChangeAIR;

    public BankOfficerPanel() {
        btnCreateAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OfficerController.createAccount();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(root, "Error: " + ex.getMessage(), "Create Account Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnChangeAIR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OfficerController.changeAIR();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(root, "Error: " + ex.getMessage(), "Change AIR Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnChangeODLim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OfficerController.changeOverdraft();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(root, "Error: " + ex.getMessage(), "Change Overdraft Limit Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel getRootPanel() {
        return root;
    }
}
