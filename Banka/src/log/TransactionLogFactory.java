package log;

import transfers.Withdraw;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionLogFactory {

    // VYBER
    public TransactionLog createWithdraw(Withdraw from, double amount) {
        return new TransactionLog(
                UUID.randomUUID().toString(),
                "WITHDRAW",
                from,
                null,
                amount,
                LocalDateTime.now()
        );
    }

    // VKLAD
    public TransactionLog createDeposit(Withdraw to, double amount) {
        return new TransactionLog(
                UUID.randomUUID().toString(),
                "DEPOSIT",
                null,
                to,
                amount,
                LocalDateTime.now()
        );
    }

    // PREVOD mezi ucty
    public TransactionLog createTransfer(Withdraw from, Withdraw to, double amount) {
        return new TransactionLog(
                UUID.randomUUID().toString(),
                "TRANSFER",
                from,
                to,
                amount,
                LocalDateTime.now()
        );
    }

}
