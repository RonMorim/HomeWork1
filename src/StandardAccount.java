public class StandardAccount implements IAccount{

    // State
    int accountNumber;
    double creditLimit;
    double balance;


    // Constructor
    public StandardAccount(int accountNumber, double creditLimit){
        this.accountNumber = accountNumber;
        if (creditLimit > 0) {
            this.creditLimit = 0;
        } else {
            this.creditLimit = creditLimit;
        }
        this.balance = 0;
    }

    // Behaviour
    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (this.balance == this.creditLimit) {
            return 0;
        } else if (amount > this.balance - this.creditLimit) {
            double currentwithdrawn = this.balance - this.creditLimit;
            this.balance =- currentwithdrawn;
            return currentwithdrawn;
        } else {
            this.balance = this.balance - amount;
            return amount;
        }
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }
}
