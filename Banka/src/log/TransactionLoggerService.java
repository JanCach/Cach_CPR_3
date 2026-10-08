package log;

import transfers.Withdraw;

import java.util.ArrayList;

public class TransactionLoggerService {

    // seznam vsech zaznamenanych transakci
    private ArrayList<TransactionLog> logs = new ArrayList<>();

    // tovarna pro vytvareni zaznamu o transakci
    private TransactionLogFactory factory = new TransactionLogFactory();


    // metoda pro zaznamenani VYBERU
    public void logWithdraw(Withdraw from, double amount) {
        logs.add( factory.createWithdraw(from, amount) );
    }

    // metoda pro zaznamenani VKLADU
    public void logDeposit(Withdraw to, double amount) {
        logs.add( factory.createDeposit(to, amount) );
    }

    // metoda pro zaznamenani PREVODU
    public void logTransfer(Withdraw from, Withdraw to, double amount) {
        logs.add( factory.createTransfer(from, to, amount) );
    }


    // medota pro vypis cele historie
    public void printLogs() {
        System.out.println("--- HISTORIE TRANSAKCI ---");

        for (TransactionLog log : logs) {
            // System.out.println(log.getType() + ": " + log.getAmount() + " Kč");
            System.out.println( log.toString() );
        }
    }
}
