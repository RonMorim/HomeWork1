public class BasicAccount extends StandardAccount{

    // State
    double withdrawalLimit;
    int withdrawCount;


    // Constructor
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        super(accountNumber, 0);
        this.withdrawalLimit = withdrawalLimit;
        this.withdrawCount = 0;
    }


    // Behaviour
    @Override
    public double Withdraw(double amount) {
        if(this.withdrawCount > 0) {
            return 0.0;
        } else {
            this.withdrawCount++;
        }

        if(this.withdrawalLimit < amount && this.withdrawalLimit > this.balance) {
            double w = this.balance;
            this.balance = 0.0;
            return w;
        } else if(this.withdrawalLimit < amount) {
            this.balance = this.balance - this.withdrawalLimit;
            return this.withdrawalLimit;
        } else {
            this.balance = this.balance - amount;
            return amount;
        }
    }

}