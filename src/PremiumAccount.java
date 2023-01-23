public class PremiumAccount extends StandardAccount {

    public PremiumAccount(int accountNumber) {
        super(accountNumber,0);

    }

    // Behaviour
    @Override
    public double Withdraw(double amount) {
        this.balance = this.balance - amount;
        return amount;
    }
}