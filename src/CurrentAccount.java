import java.time.LocalDate;

public class CurrentAccount extends BankAccounts{
    double overDraftLimit;
    double overDraftCharges;
    int duration ;
    double interestRate;

    public CurrentAccount(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate, double overDraftLimit, double interestRate,int duration) {
        super(accountNumber, accHolderName, balance, accountType, accCreationDate);
        this.overDraftLimit = overDraftLimit;
        this.interestRate = interestRate;
        this.duration = duration;
    }

    public CurrentAccount(long accountNum, String holderName, int i, String string, LocalDate date) {
        // TODO Auto-generated constructor stub
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    public double getOverDraftCharges() {
        return overDraftCharges;
    }

    public void setOverDraftCharges(double overDraftCharges) {
        this.overDraftCharges = overDraftCharges;
    }

    @Override
    public String toString() {
        return "CurrentAccount [ accountNumber=" + accountNumber
                + ", accHolderName=" + accHolderName + ", balance=" + balance + ", accountType=" + accountType
                + ", accCreationDate=" + accCreationDate + "overDraftLimit=" + overDraftLimit + ", duration=" + duration+", interestRate="
                + interestRate +"]";
    }
    public double withdraw() {
        System.out.println("Withdraw called");
        return 1;
    }

    public void displayTransactionsHistory()
    {

    }

    public int todaysTransactionCount()
    {
        return 0;
    }

    public int todaysTransactionsCount() {
        return 0;
    }
}