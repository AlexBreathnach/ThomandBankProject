package controller;

import javax.swing.*;
import java.time.LocalDate;
import model.ThomondBankGUI;
import model.Customer;
import model.Account;
import model.DepositAccount;
import model.CurrentAccount;

public class OfficerController {

    public static void createCustomer() {
        try {
            String first = JOptionPane.showInputDialog("First name:");
            String last = JOptionPane.showInputDialog("Last name:");
            String address = JOptionPane.showInputDialog("Address:");
            String dobStr = JOptionPane.showInputDialog("DOB (yyyy-mm-dd):");
            LocalDate dob = LocalDate.parse(dobStr);
            int custNo = ThomondBankGUI.customers.size() + 1;

            ThomondBankGUI.customers.add(
                    new Customer(first, last, address, dob, custNo)
            );

            JOptionPane.showMessageDialog(null, "Customer created with ID: " + custNo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage());
        }
    }

    public static void createAccount() {
        try {
            String type = JOptionPane.showInputDialog("Account type (deposit/current):");
            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Customer number:"));
            int accountId = ThomondBankGUI.thomondAccounts.size() + 1;

            if (type.equalsIgnoreCase("deposit")) {
                ThomondBankGUI.thomondAccounts.add(new DepositAccount(accountId, custNo));
            } else if (type.equalsIgnoreCase("current")) {
                double overdraft = Double.parseDouble(JOptionPane.showInputDialog("Overdraft limit:"));
                ThomondBankGUI.thomondAccounts.add(new CurrentAccount(accountId, custNo, overdraft));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid account type.");
                return;
            }

            JOptionPane.showMessageDialog(null, "Account created with ID: " + accountId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage());
        }
    }

    public static void changeAIR() {
        try {
            String type = JOptionPane.showInputDialog("Account type (deposit/current):");
            double newAIR = Double.parseDouble(JOptionPane.showInputDialog("New AIR:"));

            if (type.equalsIgnoreCase("deposit")) {
                DepositAccount.setAIR(newAIR);
            } else if (type.equalsIgnoreCase("current")) {
                CurrentAccount.setAIR(newAIR);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid account type.");
                return;
            }

            JOptionPane.showMessageDialog(null, "AIR updated.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage());
        }
    }

    public static void changeOverdraft() {
        try {
            int accountId = Integer.parseInt(JOptionPane.showInputDialog("Account ID:"));
            Account acc = findAccountById(accountId);

            if (acc instanceof CurrentAccount) {
                double newLimit = Double.parseDouble(JOptionPane.showInputDialog("New overdraft limit:"));
                ((CurrentAccount) acc).setOverdraft(newLimit);
                JOptionPane.showMessageDialog(null, "Overdraft updated.");
            } else {
                JOptionPane.showMessageDialog(null, "Not a current account.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage());
        }
    }

    private static Account findAccountById(int id) {
        for (Account acc : ThomondBankGUI.thomondAccounts) {
            if (acc.getId() == id) return acc;
        }
        return null;
    }
}
