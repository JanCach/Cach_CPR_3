package transfers;

import accounts.BusinessAccount;
import accounts.StudentAccount;
import notifiers.ConsoleNotifier;
import notifiers.Notifier;

public class TransferService {

    private static final float BUSINESS_ACCOUNT_SUB_FEE = 0.1f;
    private static final float STUDENT_ACCOUNT_LIMIT = -5000;

    Notifier notifier = new ConsoleNotifier();

    public void withdraw(Withdraw withdrawObject, double amount) {

        this.notifier.notify("Sub amount is " + amount);

        double newBalance = this.calculateNewBalance(withdrawObject, amount);

        if (newBalance < this.getWithdrawLimit(withdrawObject)) {
            throw new RuntimeException("Withdrawal limit reached");
        }

        withdrawObject.setNewBalance(newBalance);
    }

    public void addToBalance(Withdraw withdrawObject, double amount) {
        double newBalance = this.calculateNewBalance(withdrawObject, amount);

        withdrawObject.setNewBalance(newBalance);
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