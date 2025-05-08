import java.time.LocalDateTime;

public class Transaction {
    public int accountId;
    public String type;
    public double amount;
    public LocalDateTime timestamp;

    public Transaction(int accountId, String type, double amount) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return timestamp + " - " + type + ": €" + amount + " (Account ID: " + accountId + ")";
    }
}

