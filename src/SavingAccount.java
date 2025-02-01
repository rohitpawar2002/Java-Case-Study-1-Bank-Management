import java.time.LocalDate;

public class SavingAccount extends BankAccounts{
    double minBalance;
    double interestRate;

    public SavingAccount(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate, double minBalance, double interestRate) {
        super(accountNumber, accHolderName, balance, accountType, accCreationDate);
        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
