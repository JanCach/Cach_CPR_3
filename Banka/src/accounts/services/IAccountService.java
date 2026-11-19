package accounts.services;

import accounts.BankAccount;
import people.Owner;

import java.util.List;

public interface IAccountService {

    public BankAccount createCurrentAccount(Owner owner, double balance);

    public BankAccount createStudentAccount(Owner owner, double balance, String school);

    public BankAccount createSavingAccount(Owner owner, double balance);

    public BankAccount createBusinessAccount(Owner owner, double balance);

    public List<BankAccount> getAccounts();

}