package transfers;

import accounts.BusinessAccount;
import accounts.StudentAccount;
import log.TransactionLoggerService;
import notifiers.ConsoleNotifier;
import notifiers.Notifier;

public class TransferService {

    private static final float BUSINESS_ACCOUNT_SUB_FEE = 0.1f;
    private static final float STUDENT_ACCOUNT_LIMIT = -5000;

    Notifier notifier = new ConsoleNotifier();

    private final TransactionLoggerService logger;


    public TransferService(TransactionLoggerService logger) {
        this.logger = logger;
    }



    public void withdraw(Withdraw withdrawObject, double amount) {

        this.notifier.notify("Sub amount is " + amount);

        double newBalance = this.calculateNewBalance(withdrawObject, amount);

        if (newBalance < this.getWithdrawLimit(withdrawObject)) {
            throw new RuntimeException("Withdrawal limit reached");
        }

        // provedeme vyber
        withdrawObject.setNewBalance(newBalance);

        // ulozime zaznam o vyberu do historie
        logger.logWithdraw(withdrawObject, amount);
    }

    public void addToBalance(Withdraw withdrawObject, double amount) {
        // toto je podle me SPATNE - odecita to penize misto pricitani
        // double newBalance = this.calculateNewBalance(withdrawObject, amount);
        // withdrawObject.setNewBalance(newBalance);

        // podle me SPRAVNE je toto
        withdrawObject.setNewBalance(withdrawObject.getBalance() + amount);

        // ulozime zaznam o vkladu do historie
        logger.logDeposit(withdrawObject, amount);
    }

    private double calculateNewBalance(Withdraw withdrawObject, double amount) {
        double newBalance = withdrawObject.getBalance() - amount;

        if (withdrawObject instanceof BusinessAccount) {
            newBalance -= amount * BUSINESS_ACCOUNT_SUB_FEE;
        }

        return newBalance;
    }

    private double getWithdrawLimit(Withdraw withdrawObject) {

        if (withdrawObject instanceof StudentAccount) {
            return STUDENT_ACCOUNT_LIMIT;
        }

        return 0;
    }
}
