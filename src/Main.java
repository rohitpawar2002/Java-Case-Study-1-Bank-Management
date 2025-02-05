//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankManagement bm = new BankManagement("HDFC", "HBC1234");

        int choice;
        do {
            System.out.println("+------------------------------------------------------------------+");
            System.out.println(" 1. Over the counter activities                 Press-1");
            System.out.println(" 2. Account lifecycle                           Press-2");
            System.out.println(" 3. Interest Calculation                        Press-3");
            System.out.println(" 4. End of day report for daily transactions    Press-4");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("Enter your Choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    int ch;
                    do {
                        System.out.println("+------------------------------------+");
                        System.out.println(" 1.Create Account       Press-1");
                        System.out.println(" 2.Delete Account       Press-2");
                        System.out.println(" 3.Deposit              Press-3");
                        System.out.println(" 4.Withdraw             Press-4");
                        System.out.println(" 5.Check Balance        Press-5");
                        System.out.println(" 6.Account Statement    Press-6");
                        System.out.println(" 7.Pay Emi              Press-7");
                        System.out.println(" 8.Go to Main Menu      Press-0");
                        System.out.println("+------------------------------------+");
                        System.out.println("Enter your choice");
                        ch = sc.nextInt();

                        switch (ch) {
                            case 1: {
                                if (bm.createAccount()) {
                                    System.out.println("Account Created Successfully!!!!");
                                }
                                break;
                            }
                            case 2: {
                                int result = bm.accountDelete();
                                if (result == 0)
                                    System.out.println("Account deleted");
                                else if (result == -1)
                                    System.out.println("You cannot delete account");
                                else
                                    System.out.println("Enter correct account number");
                                break;
                            }
                            case 3: {
                                boolean result = bm.deposit();
                                if (result) {
                                    System.out.println("Amount Deposited Successfully!!!");
                                }
                                break;
                            }
                            case 4: {
                                boolean result = bm.withdraw();
                                if (result) {
                                    System.out.println("Amount withdraw Successfully!!!");
                                }
                                break;
                            }
                            case 5: {
                                if (bm.checkBalance() == -1) {
                                    System.out.println("Plz Enter correct account number");
                                }
                                break;
                            }
                            case 6: {
                                bm.accountStatement();
                                break;
                            }
                            case 7: {
                                bm.payEmi();
                                break;
                            }
                            case 8: {
                                break;
                            }
                            case 9: {
                                System.out.println("Enter correct choice");
                                break;
                            }
                        }
                    } while (ch != 0);
                    break;
                }
                case 2: {
                    int ch;

                    do {
                        System.out.println("+------------------------------+");
                        System.out.println(" 1.Account statement    Press-1");
                        System.out.println(" 2.Go to Main Menu    Press-0");
                        System.out.println("+------------------------------+");
                        System.out.println("Enter your choice");
                        ch = sc.nextInt();

                        switch (ch) {
                            case 1: {
                                bm.accountStatement();
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                System.out.println("Enter correct choice");
                                break;
                            }
                        }
                    } while (ch != 0);
                    break;
                }
                case 3: {
                    int ch;

                    do {
                        System.out.println("+-----------------------------------+");
                        System.out.println(" 1.Check Interest        Press-1");
                        System.out.println(" 2.Deposit Interest      Press-2");
                        System.out.println(" 2.Go to Main Menu       Press-0");
                        System.out.println("+-----------------------------------+");
                        System.out.println("Enter your choice");
                        ch = sc.nextInt();

                        switch (ch) {
                            case 1: {
                                bm.checkInterest();
                                break;
                            }
                            case 2: {
                                System.out.println("re");
                                break;
                            }
                            case 3: {
                                break;
                            }
                            case 4: {
                                System.out.println("Enter correct choice");
                            }
                        }
                    } while (ch != 0);
                    break;
                }
                case 4: {
                    int ch;

                    do {
                        System.out.println("+---------------------------------+");
                        System.out.println(" 1.Daily Report             Press-1");
                        System.out.println(" 2.Basic Daily Report       Press-2");
                        System.out.println(" 3.Go to Main Menu          Press-0");
                        System.out.println("+---------------------------------+");
                        System.out.println("Enter your choice");
                        ch = sc.nextInt();

                        switch (ch) {
                            case 1: {
                                bm.dailyReport();
                                break;
                            }
                            case 2: {
                                bm.basicDailyReport();
                                break;

                            }
                            case 3: {
                                break;
                            }
                            case 4: {
                                System.out.println("Enter correct choice");
                                break;
                            }
                        }
                    } while (ch != 0);
                    break;
                }
            }

        } while (choice != 0);
    }

}