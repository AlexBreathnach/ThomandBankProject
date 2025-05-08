package controller;

import javax.swing.*;
import model.Account;
import model.ThomondBankGUI;

public class ATMController {

    public static void deposit(String accountIdStr) {
        try {
            int accountId = Integer.parseInt(accountIdStr);
            Account acc = findAccountById(accountId);

            if (acc != null) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                double amount = Double.parseDouble(amountStr);
                acc.deposit(amount);
                JOptionPane.showMessageDialog(null, "Deposit successful. New balance: €" + acc.getBalance());
            } else {
                JOptionPane.showMessageDialog(null, "Account not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    public static void withdraw(String accountIdStr) {
        try {
            int accountId = Integer.parseInt(accountIdStr);
            Account acc = findAccountById(accountId);

            if (acc != null) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                double amount = Double.parseDouble(amountStr);
                boolean success = acc.withdraw(amount);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: €" + acc.getBalance());
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Account not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    public static void checkBalance(String accountIdStr) {
        try {
            int accountId = Integer.parseInt(accountIdStr);
            Account acc = findAccountById(accountId);

            if (acc != null) {
                JOptionPane.showMessageDialog(null, "Current balance: €" + acc.getBalance());
            } else {
                JOptionPane.showMessageDialog(null, "Account not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    private static Account findAccountById(int id) {
        for (Account acc : ThomondBankGUI.thomondAccounts) {
            if (acc.getId() == id) return acc;
        }
        return null;
    }
}
