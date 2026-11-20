import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Account [] acct = new Account[100];
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Kingsley bank service");
        System.out.println("To continue you have to create a new account");
        System.out.println("Press enter to start making the account");
        input.nextLine();
        Account newAcct = newAccount();
        int acctLength = 0;
        acct[acctLength] = newAcct;

        properties(newAcct, acct);


        while (true) {
            try {
                System.out.println("Do you wish to exit(yes/no)");
                String opt = input.nextLine();
                if (opt.equals("yes")) {
                    System.out.println("Exiting");
                    break;
                } else if (opt.equals("no")) {
                    while (true) {
                        try {
                            System.out.println("Do you want to create a new account or log in your old account(signup/login");
                            String userChoice = input.nextLine();
                            if (userChoice.equals("signup")) {
                                acctLength++;
                                Account anotherNewAcc = newAccount();
                                acct[acctLength] = anotherNewAcc;
                                properties(anotherNewAcc, acct);
                            } else if (userChoice.equals("login")) {
                                while (true) {
                                    try {
                                        System.out.println("What is your user name");
                                        String userName = input.nextLine();
                                        System.out.println("what is your password");
                                        String pin = input.nextLine();
                                        for (Account accounts: acct) {
                                            if (accounts.getUsername().equals(userName) && accounts.getPassword().equals(pin)) {
                                                System.out.println("You have successfully logged in" + accounts.getUsername());
                                                properties(accounts, acct);
                                                break;
                                            }
                                        }
                                        break;
                                    } catch (NullPointerException e) {
                                        System.out.println("CHECKING...");
                                    }

                                }

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }



                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }


    }
    public static Account newAccount(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = input.nextLine();
        int phoneNumber;
        while (true) {
            try {
                System.out.println("Enter your phone number: ");
                String phoneNumberString = input.nextLine();
                phoneNumber = Integer.parseInt(phoneNumberString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid phone number");
                System.out.println("HINT: make the phone number less than 11 numbers");
            }
        }

        System.out.println("Enter your email: ");
        String email = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();

        double balance = 0.0d;
        return new Account(userName, balance, password, email, phoneNumber);
    }

    public static void properties(Account acc, Account[] accountArray) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello " + acc.getUsername() + " or " + acc.getEmail());
        while (true) {
            System.out.println("Your account number is: " + acc.getAccNumber());
            System.out.println("Enter an option you want to do to your account");
            System.out.println("""
                    1).Deposit funds, 2).Withdraw funds, 3).Transfer funds
                    4).Check balance 5).edit account
                    6).log out""");
            String userChoice = input.nextLine();
            if (userChoice.equals("1")) {
                acc.depositFunds();
            } else if (userChoice.equals("2")) {
                acc.withdrawFunds();
            } else if (userChoice.equals("3")) {
                transferFunds(accountArray, acc);
            }
            else if (userChoice.equals("4")) {
                System.out.println(acc.getUsername() + " Your main balance is $" + acc.getBalance());
            }else if (userChoice.equals("5")) {
                acc.editUser();
            } else if (userChoice.equals("6")) {
                System.out.println("Logging out!!!");
                input.nextLine();
                return;
            } else {
                System.out.println("Wrong input");
            }
        }

    }

    public static void transferFunds(Account[] accountArray, Account acc) {
        Scanner input = new Scanner(System.in);
        Account myAcc = new Account();
        System.out.println("hello, " + acc.getUsername());
        System.out.println("You currently have $" + acc.getBalance());
        System.out.println("What is the recipients account number: ");
        String SAccNum = input.nextLine();
        int accNum = Integer.parseInt(SAccNum);
        System.out.println("How much do you want to send");
        String SAmount = input.nextLine();
        int amount = Integer.parseInt(SAmount);
        if (acc.getBalance() < amount) {
            System.out.println("Insufficient funds");
        }
        for (Account accounts: accountArray) {
            if (accNum == accounts.getAccNumber()) {
                System.out.println("User, " +  accounts.getUsername() + " found");
                myAcc = accounts;
                break;
            }
        }
        if (myAcc.getAccNumber() != accNum) {
            System.out.println("User not found");
        } else {
            for (int i = 5; i >= 0; i--) {
                System.out.println("What is your password");
                String pin = input.nextLine();
                if (!acc.checkPassword(pin)) {
                    System.out.println("Wrong password");
                    continue;
                }
                acc.setBalance(acc.getBalance() - amount);
                myAcc.setBalance(myAcc.getBalance() + amount);
                System.out.println("Transfer funds successfully");
                System.out.println("Current balance is: " + acc.getBalance());
                break;
            }
        }



    }


}
