package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.officerController;

public class bankOfficer {
    private JPanel root;
    private JButton btnCreateAcc;
    private JButton btnChangeODLim;
    private JButton btnChangeAIR;

    public bankOfficer() {
        btnCreateAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                officerController.createAccount();
            }
        });
        btnChangeAIR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                officerController.changeAIR();
            }
        });
        btnChangeODLim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                officerController.changeOverdraft();
            }
        });
        public JPanel getRootPanel() {
            return root;
    }
}
