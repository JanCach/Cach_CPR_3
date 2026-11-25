package accounts.services;

import accounts.BankAccount;
import people.Owner;

import java.util.List;

public interface IAccountService {

    public BankAccount createCurrentAccount(Owner owner, double balance, String currency);

    public BankAccount createStudentAccount(Owner owner, double balance, String currency, String school);

    public BankAccount createSavingAccount(Owner owner, double balance, String currency);

    public BankAccount createBusinessAccount(Owner owner, double balance, String currency);

    public List<BankAccount> getAccounts();

}