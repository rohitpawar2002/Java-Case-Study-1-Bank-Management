import java.time.LocalDate;

public class LoanAccount extends BankAccounts{
    double loanAmount;
    double interestRate;
    int tenureMonths;
    String loanType;
    double emiPayment;

    public LoanAccount(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate, double loanAmount, double interestRate, int tenureMonths, String loanType, double emiPayment) {
        super(accountNumber, accHolderName, balance, accountType, accCreationDate);
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.loanType = loanType;
        this.emiPayment = emiPayment;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(int tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getEmiPayment() {
        return emiPayment;
    }

    public void setEmiPayment(double emiPayment) {
        this.emiPayment = emiPayment;
    }
}
