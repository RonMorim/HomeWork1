import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank{

    // State
    List <IAccount> accounts;

    // Constructor
    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // Behaviour
    @Override
    public void OpenAccount(IAccount account) {
        this.accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for(IAccount account : this.accounts) {
            if(account.GetAccountNumber() == accountNumber) {
                if(account.GetCurrentBalance() >= 0) {
                    this.accounts.remove(account);
                    break;
                }
                else {
                    System.out.println("The account is not closed due to debt");
                }
            }
        }
    }

    @Override
    public List <IAccount> GetAllAccounts() {
        return this.accounts;
    }

    @Override
    public List <IAccount> GetAllAccountsInDebt() {
        List <IAccount> accountsWithDebt = new ArrayList<>();
        for(IAccount account : this.accounts) {
            if(account.GetCurrentBalance() < 0) {
                accountsWithDebt.add(account);
            }
        }
        return accountsWithDebt;
    }

    @Override
    public List <IAccount> GetAllAccountsWithBalance(double balancelim) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for(IAccount account : this.accounts) {
            if(account.GetCurrentBalance() > balancelim) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }

    public static void main(String[] args) {
        StandardAccount standard1 = new StandardAccount(1, -500);
        BasicAccount basic1 = new BasicAccount(2, 150);
        PremiumAccount premium1 = new PremiumAccount(3);
        StandardAccount standard2 = new StandardAccount(4, -100);
        StandardAccount standard3 = new StandardAccount(5, -200);
        PremiumAccount premium2 = new PremiumAccount(6);
        StandardAccount standard4 = new StandardAccount(7, -300);
        BasicAccount basic2 = new BasicAccount(8, 250);
        BasicAccount basic3 = new BasicAccount(9,200);
        Bank bank = new Bank();
        bank.OpenAccount(standard1);
        bank.OpenAccount(basic1);
        bank.OpenAccount(premium1);
        bank.OpenAccount(standard2);
        bank.OpenAccount(standard3);
        bank.OpenAccount(premium2);
        bank.OpenAccount(standard4);
        bank.OpenAccount(basic2);
        bank.OpenAccount(basic3);
        List<IAccount> allAccounts = bank.GetAllAccounts();
        for (IAccount account : allAccounts) {
            System.out.println("The balance of account number " + account.GetAccountNumber() + " is:" + account.GetCurrentBalance()) ;
        }
        standard1.Withdraw(200);
        basic1.Deposit(500);
        premium1.Deposit(300);
        List<IAccount> accountWithBalance = bank.GetAllAccountsWithBalance(200) ;
        for (IAccount account : accountWithBalance) {
            System.out.println("Account number " + account.GetAccountNumber() + " has balance more than 200");
        }
        bank.CloseAccount(standard4.GetAccountNumber());
        bank.CloseAccount(premium2.GetAccountNumber());
    }
}