import java.time.LocalDate;

public class SalaryAccount extends BankAccounts{
    double salary;
    LocalDate lastTransactionDate;
    boolean isFreez;


    public SalaryAccount(long accountNumber, String accHolderName, double balance, String accountType, LocalDate accCreationDate, double salary, LocalDate lastTransactionDate, boolean isFreez) {
        super(accountNumber, accHolderName, balance, accountType, accCreationDate);
        this.salary = salary;
        this.lastTransactionDate = lastTransactionDate;
        this.isFreez = isFreez;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(LocalDate lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public boolean isFreez() {
        return isFreez;
    }

    public void setFreez(boolean freez) {
        isFreez = freez;
    }
}
