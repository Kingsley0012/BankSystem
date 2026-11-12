import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Account [] acct = new Account[5];
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to kingsley bank service");
        System.out.println("To continue you have to create a new account");
        System.out.println("Press enter to start making the account");
        input.nextLine();
        Account newAcct = newAccount();
        int acctLength = 0;
        acct[acctLength] = newAcct;
        newAcct.getAccNumber();

        properties(newAcct);


        while (true) {
            System.out.println("Do you wish to exit or continue(yes/no)");
            String opt = input.nextLine();
            if (opt.equals("exit")) {
                System.out.println("Exiting");
                break;
            } else if (opt.equals("continue")) {

                while (true) {
                    System.out.println("Do you want to create a new account or log in your old account(signup/login");
                    String userChoice = input.nextLine();
                    if (userChoice.equals("signup")) {
                        acctLength++;
                        Account anotherNewAcc = newAccount();
                        acct[acctLength] = anotherNewAcc;
                        properties(anotherNewAcc);
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
                                        properties(accounts);
                                        break;
                                    } else {
                                        continue;
                                    }
                                }
                                break;
                            } catch (NullPointerException e) {
                                System.out.println("CHECKING...");
                            }

                        }

                    }
                }



            } else {
                System.out.println("Invalid input");
            }
        }


    }
    public static Account newAccount(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = input.nextLine();
        int phoneNumber = 0;
        while (true) {
            try {
                System.out.println("Enter your phone number: ");
                String phoneNumberString = input.nextLine();
                phoneNumber = Integer.parseInt(phoneNumberString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid phone number");
                System.out.println("HINT: make the phone number less than 11 numbers");
                continue;
            }
        }

        System.out.println("Enter your email: ");
        String email = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();

        double balance = 0.0d;
        return new Account(userName, balance, password, email, phoneNumber);
    }

    public static void properties(Account acc) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello " + acc.getUsername() + " or " + acc.getEmail());
        while (true) {
            System.out.println("Your account number is: " + acc.getAccNumber());
            System.out.println("Enter an option you want to do to your account");
            System.out.println("1).Deposit funds, 2).Withdraw funds\n3).Check balance 4).edit account, 5).log out");
            String userChoice = input.nextLine();
            if (userChoice.equals("1")) {
                acc.depositFunds();
            } else if (userChoice.equals("2")) {
                acc.withdrawFunds();
            }else if (userChoice.equals("3")) {
                System.out.println(acc.getUsername() + " Your main balance is $" + acc.getBalance());
            }else if (userChoice.equals("4")) {
                acc.editUser();
            } else if (userChoice.equals("5")) {
                System.out.println("Logging out!!!");
                input.nextLine();
                return;
            } else {
                System.out.println("Wrong input");
            }
        }

    }

}
