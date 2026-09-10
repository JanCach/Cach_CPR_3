import accounts.BankAccount;
import accounts.CurrentAccount;
import accounts.StudentAccount;
import people.AccountOwner;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    /*
     * Ukol na 17. 9.
     *
     * Vytvořit další typy účtů a rozšířit stávající:
     *
     * Studentský účet
     *  - povolit výběr 5 000 do záporu
     *
     * Spořící účet
     *  - když přidám peníze na účet, připíše se mi i 0,5% úrok
     *
     * Podnikatelský účet
     *  - každý výběr odečte transakční poplatek 1%
     *
     */

    public static void main(String[] args) {

        AccountOwner owner = new AccountOwner("Tomas", "Pesek");

        List<BankAccount> accounts = new ArrayList<>();

        BankAccount bankAccount = new CurrentAccount(owner, 100);
        accounts.add(bankAccount);

        BankAccount studentAccount = new StudentAccount(owner, 100);
        accounts.add(studentAccount);


        for (BankAccount account : accounts) {

            if (account instanceof StudentAccount) {

                StudentAccount overrideAccount = (StudentAccount) account;
                System.out.println("school: " + overrideAccount.getSchool());
            }
        }




        bankAccount.add(500);
        bankAccount.add(300);
        bankAccount.add(100);

        bankAccount.sub(500);
        bankAccount.sub(500);
        bankAccount.sub(500);



        System.out.println("balance: " + bankAccount.getBalance());
    }
}