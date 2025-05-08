import gui.ATMUser;
import gui.BankOfficerPanel;
import gui.BankManagerPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] roles = {"ATM User", "Bank Officer", "Bank Manager"};
            String selectedRole = (String) JOptionPane.showInputDialog(
                    null,
                    "Select user type:",
                    "Login",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    roles,
                    roles[0]
            );

            if (selectedRole == null) {
                System.exit(0); // Cancel clicked
            }

            JFrame frame = new JFrame("Thomond Bank - " + selectedRole);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            switch (selectedRole) {
                case "ATM User":
                    frame.setContentPane(new ATMUser().getRootPanel());
                    break;
                case "Bank Officer":
                    frame.setContentPane(new BankOfficerPanel().getRootPanel());
                    break;
                case "Bank Manager":
                    frame.setContentPane(new BankManagerPanel().getRootPanel());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Unknown user type selected.");
                    System.exit(1);
            }

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
