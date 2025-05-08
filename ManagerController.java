package controller;

import javax.swing.*;
import java.time.LocalDate;
import model.ThomondBankGUI;
import model.BankOfficer;

public class ManagerController {

    public static void createBankOfficer() {
        try {
            String first = JOptionPane.showInputDialog("First name:");
            String last = JOptionPane.showInputDialog("Last name:");
            String address = JOptionPane.showInputDialog("Address:");
            String dobStr = JOptionPane.showInputDialog("DOB (yyyy-mm-dd):");
            LocalDate dob = LocalDate.parse(dobStr);
            int empNo = ThomondBankGUI.thomondStaff.size() + 1;
            String jobTitle = "Bank Officer";

            ThomondBankGUI.thomondStaff.add(
                    new BankOfficer(first, last, address, dob, empNo, jobTitle)
            );

            JOptionPane.showMessageDialog(null, "Bank officer created with ID: " + empNo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage());
        }
    }
}
