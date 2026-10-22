package accounts.serialization;

import accounts.BankAccount;
import java.util.List;

public interface BankAccountSerialization {
    String serialize(BankAccount bankAccount);
    String serializeAll(List<BankAccount> bankAccounts);
}