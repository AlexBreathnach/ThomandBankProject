public class DepositAccount extends Account {
    public static double AIR = 0.02; // Annual Interest Rate

    public DepositAccount(int id, int custNo) {
        super(id, custNo);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public static void setAIR(double newRate) {
        AIR = newRate;
    }

    public static double getAIR() {
        return AIR;
    }
}

