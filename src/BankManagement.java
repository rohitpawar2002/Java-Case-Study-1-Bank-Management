import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class BankManagement {
    Scanner sc = new Scanner(System.in);
    String bankName;
    String IFSCCode;
    double openingBalance = 100;
    double temp = openingBalance;       // Change
    int accountCount = 1;
    Random rand = new Random();
    BankAccounts[] account;

    public BankManagement(String bankName, String IFSCCode) {
        this.bankName = bankName;
        this.IFSCCode = IFSCCode;

        account = new BankAccounts[20];

        account[0] = new SalaryAccount(1234566, "Rohit Pawar", 100, "Saving", LocalDate.of(2024, 11, 12), LocalDate.now());

    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public int findAccount(long accNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (account[i].accountNumber == accNumber) {
                return i;
            }
        }
        return -1;
    }

    public boolean deposit() {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();
        int index = findAccount(accNo);
        if (index != -1) {

            double amount = account[index].deposit();
            if (amount == -1) {
                System.out.println("Your Account is Frozen.");
            } else {
                openingBalance += amount;
                return true;
            }
        }
        return false;

    }

    public boolean withdraw() {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();
        int index = findAccount(accNo);
        if (index != -1) {

            double amount = account[index].withdraw();
            if (amount == -1) {
                System.out.println("Your Account is Frozen.");
            } else if (amount == -2) {
                System.out.println("You can not withdraw money plz pay your loan amount first");
            } else if (amount == -3) {
                System.out.println("You cannot withdraw money because your balance is less than 10000");
            } else {
                openingBalance -= amount;
                return true;

            }

        }
        return false;
    }

    public int checkBalance() {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();
        int index = findAccount(accNo);
        if (index != -1) {
            System.out.println(account[index].getBalance());
            return 0;
        }

        return -1;
    }

    public boolean createAccount() {
        System.out.println("Which Type of Account you want to open:");
        System.out.println("1.Saving\n2.Salary.\n3.current.\n4Loan ");
        int ch = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Holder Name:");
        String holderName = sc.nextLine();
        LocalDate date = LocalDate.now();
        long accNumber = rand.nextLong(1000);
        if (ch == 1) {
            System.out.println("Enter much Initial balance you want to add");
            double balance = sc.nextDouble();
            if (balance < 10000) {
                System.out.println("You have to add 10000 minimum initial balance");
                return false;
            } else {
                account[accountCount++] = new SavingAccount(accNumber, holderName, balance, "Saving", date, 4);
                System.out.println("Your account number is : " + accNumber);
                openingBalance += 10000;
            }

        } else if (ch == 2) {
            System.out.println("Enter much Initial balance you want to add");
            double balance = sc.nextDouble();
            account[accountCount++] = new SalaryAccount(accNumber, holderName, balance, "Salary", date, date);
            System.out.println("Your account number is : " + accNumber);
            openingBalance += 0;
        } else if (ch == 3) {
            System.out.println("Enter much Initial balance you want to add");
            double balance = sc.nextDouble();
            account[accountCount++] = new CurrentAccount(accNumber, holderName, balance, "Current", date, 50000, 10, 30);
            System.out.println("Your account number is : " + accNumber);
            openingBalance += 0;

        } else if (ch == 4) {
            System.out.println("How much Loan Amount you required :");
            double amount = sc.nextDouble();
            System.out.println("when you will pay full loan amount");
            int tMonths = sc.nextInt();
            account[accountCount++] = new LoanAccount(accNumber, holderName, amount, "Loan", date, 7.5, tMonths, "Home", 500);
            System.out.println("Your account number is : " + accNumber);
            openingBalance -= amount;
        }

        return true;
    }

    public void accountStatement() {
        System.out.println("Enter Account Number:");
        int accNum = sc.nextInt();
        int index = findAccount(accNum);
        if (index != -1) {
            account[index].displayTransactionsHistory();
        }

    }

    public void dailyReport() {
        int count = 0;

        System.out.println("Today's Created Accounts:");
        for (int i = 0; i < accountCount; i++) {
            if (account[i].accCreationDate.isEqual(LocalDate.now())) {
                account[i].displayAccInfo();
                count++;
            }
        }
        System.out.println("Total Number of Account Created:" + count);

        System.out.println("Today's Transactions:");
        int totalTransactionCount = 0;
        for (int i = 0; i < accountCount; i++) {
            totalTransactionCount += account[i].todaysTransactionCount();
        }
        System.out.println("Today's Transactions Count:" + totalTransactionCount);
        System.out.println("Bank Opening Balance " + temp);
        System.out.println("Bank Closing Balance " + openingBalance);

    }

    public boolean accountDelete() {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();
        int index = findAccount(accNo);
        if (index != -1) {
            if (account[index] instanceof LoanAccount ) {
                if (account[index].getBalance() >= 0) {
                    for (int j = index; j < accountCount; j++) {
                        account[index] = account[index + 1];
                    }
                    accountCount--;
                    return true;
                }
            }
        }
        return false;
    }

}