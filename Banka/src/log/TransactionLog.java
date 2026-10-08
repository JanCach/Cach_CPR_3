package log;

import transfers.Withdraw;

import java.time.LocalDateTime;

public class TransactionLog {

    private String id;
    private String type;
    private Withdraw from;
    private Withdraw to;
    private double amount;
    private LocalDateTime createdAt;

    public TransactionLog(
            String id,
            String type,
            Withdraw from,
            Withdraw to,
            Double amount,
            LocalDateTime createdAt
            ) {
        this.id = id;
        this.type = type;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    // getter
//    public String getId() { return this.id; }
//    public String getType() { return this.type; }
//    public double getAmount() { return this.amount; }
    // ... a dalsi, pokud budou potreba


    @Override
    public String toString() {
        return "Transakce ID: " + this.id
                + "\nTyp: " + this.type
                + "\nZ účtu: " + this.from
                + "\nNa účet: " + this.to
                + "\nČástka: " + this.amount
                + "\n-----------------";
    }

}
