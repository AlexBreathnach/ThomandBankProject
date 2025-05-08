public class CurrentAccount extends Account {
    public static double AIR = 0.005;
    private double overdraft;

    public CurrentAccount(int id, int custNo, double overdraft) {
        super(id, custNo);
        this.overdraft = overdraft;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= (balance + overdraft)) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public static void setAIR(double newRate) {
        AIR = newRate;
    }

    public static double getAIR() {
        return AIR;
    }
}

