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
    int accountCount = 2;
    Random rand = new Random();
    BankAccounts[] account;
    int deletedAccCount = 0;
    BankAccounts[] deletedAcc = new BankAccounts[50];

    public BankManagement(String bankName, String IFSCCode) {
        this.bankName = bankName;
        this.IFSCCode = IFSCCode;

        account = new BankAccounts[20];

        account[0] = new SalaryAccount(1234566, "Rohit Pawar", 100, "Saving", LocalDate.of(2024, 11, 12), LocalDate.now());
        account[1] = new LoanAccount(123,"Abc ert",1000,"Loan Account",LocalDate.of(2023, 1, 1),7.5,6,"Home Loan",6);

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
        System.out.println("+--------------------------------------------+");
        System.out.println("Which Type of Account you want to open:");
        System.out.println("1.Saving\n2.Salary\n3.current\n4.Loan ");
        System.out.println("+--------------------------------------------+");
        System.out.println("Enter your choice");
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
                System.out.println("+------------------------------------------------+");
                System.out.println("Your account number is : " + accNumber);
                System.out.println("Account Holder Name : "+holderName);
                System.out.println("Account type : Saving");
                System.out.println("+------------------------------------------------+");
                openingBalance += 10000;
            }

        } else if (ch == 2) {
            System.out.println("Enter much Initial balance you want to add");
            double balance = sc.nextDouble();
            account[accountCount++] = new SalaryAccount(accNumber, holderName, balance, "Salary", date, date);
            System.out.println("+------------------------------------------------+");
            System.out.println("Your account number is : " + accNumber);
            System.out.println("Account Holder Name : "+holderName);
            System.out.println("Account type : Salary");
            System.out.println("+------------------------------------------------+");
            openingBalance += 0;
        } else if (ch == 3) {
            System.out.println("Enter much Initial balance you want to add");
            double balance = sc.nextDouble();
            account[accountCount++] = new CurrentAccount(accNumber, holderName, balance, "Current", date, 30);
            System.out.println("+------------------------------------------------+");
            System.out.println("Your account number is : " + accNumber);
            System.out.println("Account Holder Name : "+holderName);
            System.out.println("Account type : Current");
            System.out.println("+------------------------------------------------+");
            openingBalance += 0;

        } else if (ch == 4) {
            System.out.println("How much Loan Amount you required :");
            double amount = sc.nextDouble();
            System.out.println("when you will pay full loan amount");
            int tMonths = sc.nextInt();
            account[accountCount++] = new LoanAccount(accNumber, holderName, amount, "Loan", date, 7.5, tMonths, "Home", 500);
            System.out.println("+------------------------------------------------+");
            System.out.println("Your account number is : " + accNumber);
            System.out.println("Account Holder Name : "+holderName);
            System.out.println("Account type : Loan");
            System.out.println("+------------------------------------------------+");
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
        int Dcount = 0;


        System.out.println("+----------------------------------------------------------+");
        System.out.println("Today's Created Accounts:");
        System.out.println("");
        for (int i = 0; i < accountCount; i++) {
            if (account[i].accCreationDate.isEqual(LocalDate.now())) {
                account[i].displayAccInfo();
                count++;
            }
        }

        for (int i=0;i<deletedAccCount;i++)
        {
            if(deletedAcc[i].accCreationDate.isEqual(LocalDate.now()))
            {
                deletedAcc[i].displayAccInfo();
                count++;
            }
        }
        System.out.println("");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("Todays Deleted Accounts :-");
        System.out.println("");
        for (int i = 0 ; i<deletedAccCount ; i++)
        {
            if(deletedAcc[i].accCreationDate.isEqual(LocalDate.now()))
            {
                deletedAcc[i].displayAccInfo();
                Dcount++;
            }
        }
        System.out.println("");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("Total Number of deleted account:"+Dcount);
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Total Number of Account Created:" + count);
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Today's Transactions:");
        System.out.println("");
        int totalTransactionCount = 0;
        for (int i = 0; i < accountCount; i++) {
            totalTransactionCount += account[i].todaysTransactionCount();
        }
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Today's Transactions Count:" + totalTransactionCount);
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Bank Opening Balance " + temp);
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Bank Closing Balance " + openingBalance);
        System.out.println("+----------------------------------------------------------+");
    }

    public void basicDailyReport()
    {
        int count = 0;
        int Dcount = 0;

        for (int i = 0; i < accountCount; i++) {
            if (account[i].accCreationDate.isEqual(LocalDate.now())) {
                //account[i].displayAccInfo();
                count++;
            }
        }

        for (int i=0;i<deletedAccCount;i++)
        {
            if(deletedAcc[i].accCreationDate.isEqual(LocalDate.now()))
            {
                //deletedAcc[i].displayAccInfo();
                count++;
            }
        }
        System.out.println("");
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Total Number of Account Created:" + count);
        System.out.println("+----------------------------------------------------------+");

        for (int i = 0 ; i<deletedAccCount ; i++)
        {
            if(deletedAcc[i].accCreationDate.isEqual(LocalDate.now()))
            {
                //deletedAcc[i].displayAccInfo();
                Dcount++;
            }
        }

        System.out.println("Total Number of Account Deleted:"+Dcount);
        int totalTransactionCount = 0;
        for (int i = 0; i < accountCount; i++) {
            totalTransactionCount += account[i].todaysTransactionsCount();
        }
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Today's Transactions Count:" + totalTransactionCount);
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Bank Opening Balance " + temp);
        System.out.println("+----------------------------------------------------------+");
        System.out.println("Bank Closing Balance " + openingBalance);
        System.out.println("+----------------------------------------------------------+");
    }

    public int accountDelete() {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();
        int index = findAccount(accNo);
        if (index != -1) {
            if (account[index] instanceof LoanAccount || account[index] instanceof CurrentAccount) {
                if (account[index].getBalance() >= 0) {
                    deletedAcc[deletedAccCount] = account[index];
                    deletedAccCount++;
                    for (int j = index; j < accountCount; j++) {
                        account[index] = account[index + 1];
                    }
                    accountCount--;
                    return 0;
                } else
                    return -1;
            } else {
                if (account[index].getBalance() >= 0) {
                    deletedAcc[deletedAccCount] = account[index];
                    deletedAccCount++;
                    for (int j = index; j < accountCount; j++) {
                        account[index] = account[index + 1];
                    }
                    accountCount--;
                    return 0;
                } else
                    return -1;
            }
        }
        return -2;
    }

    public void payEmi() {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();
        int index = findAccount(accNo);
        if (index != -1) {
            if (account[index] instanceof LoanAccount) {
                LoanAccount l1 = (LoanAccount) account[index];
                double result = l1.payEMI();
                openingBalance +=result;
            }
            else
                System.out.println("Your account is not Loan Account you cannot payEmi");
        }
    }

    public void checkInterest()
    {
        System.out.println("Enter account number");
        long accNo = sc.nextLong();
        int index = findAccount(accNo);
        if (index != -1) {
            if (account[index] instanceof LoanAccount )
            {
                LoanAccount l = (LoanAccount) account[index];
                l.checkLoanInterest();
            }
            else if(account[index] instanceof SavingAccount)
            {
                SavingAccount s = (SavingAccount) account[index];
                s.checkLoanInterest();
            }
            else
                System.out.println("interest rate is for only saving and loan and Your account is not saving or loan");
        }
    }

}