package accounts.serialization;

import accounts.BankAccount;

public class BankAccountSerializeFactory {

    public BankAccountSerialize createBankAccountSerialize(BankAccount bankAccount) {
        BankAccountSerialize dto = new BankAccountSerialize();
        dto.bankAccountNumber = bankAccount.getAccountNumber();
        return dto;
    }
}