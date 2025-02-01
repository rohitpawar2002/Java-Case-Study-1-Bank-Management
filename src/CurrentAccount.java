import java.time.LocalDate;

public class CurrentAccount extends BankAccounts{
    double overDraftLimit;
    double overDraftCharges;

    public CurrentAccount(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate, double overDraftLimit, double overDraftCharges) {
        super(accountNumber, accHolderName, balance, accountType, accCreationDate);
        this.overDraftLimit = overDraftLimit;
        this.overDraftCharges = overDraftCharges;
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
}

