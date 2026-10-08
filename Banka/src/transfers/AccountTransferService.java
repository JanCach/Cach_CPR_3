package transfers;

import accounts.BusinessAccount;
import accounts.StudentAccount;
import log.TransactionLoggerService;
import notifiers.ConsoleNotifier;
import notifiers.Notifier;

public class AccountTransferService {

    private static final float BUSINESS_ACCOUNT_TRANSFER_FEE = 0.003f;
    private static final float STUDENT_ACCOUNT_LIMIT = -5000;

    Notifier notifier = new ConsoleNotifier();

    private final TransactionLoggerService logger;

    public AccountTransferService(TransactionLoggerService logger) {
        this.logger = logger;
    }


    public void transfer(Withdraw fromObject, Withdraw toObject, double amount) {
        this.notifier.notify("Tranfer amount is " + amount);

        // vypocitam, kolik penez by zustalo po prevodu na zdrojovem uctu
        double newFromBalance = this.calculateNewBalance(fromObject, amount);

        // vyhodim chybu, kdyz se snazim prevest vice penez, nez je mozne
        if (newFromBalance < this.getWithdrawLimit(fromObject)) {
            throw new RuntimeException("Withdrawal limit reached");
        }

        // spocitam, kolik penez bude po prevodu na cilovem uctu
        double newToBalance = toObject.getBalance() + amount;

        // provedeme prevod
        fromObject.setNewBalance(newFromBalance);
        toObject.setNewBalance(newToBalance);

        // zaznamename prevod do historie
        logger.logTransfer(fromObject, toObject, amount);
    }

    private double calculateNewBalance(Withdraw withdrawObject, double amount) {
        double newBalance = withdrawObject.getBalance() - amount;

        if (withdrawObject instanceof BusinessAccount) {
            newBalance -= amount * BUSINESS_ACCOUNT_TRANSFER_FEE;
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
