// package accounts;

package accounts;

import people.Owner;

public class BankAccountFactory {

    public static BankAccount createAccount(AccountType type, Owner owner, double initialBalance) {
        return createAccount(type, owner, initialBalance, null);
    }

    public static BankAccount createAccount(AccountType type, Owner owner, double initialBalance, String school) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Počáteční zůstatek nesmí být záporný.");
        }

        return switch (type) {
            case CURRENT -> new CurrentAccount(owner, initialBalance);
            case BUSINESS -> new BusinessAccount(owner, initialBalance);
            case SAVINGS -> new SavingsAccount(owner, initialBalance);
            case STUDENT -> new StudentAccount(owner, school); // Případně vytvořte konstruktor s oběma parametry
        };
    }
}