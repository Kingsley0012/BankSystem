import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to kingsley bank service");
        System.out.println("To continue you have to create a new account");
        System.out.println("Press enter to start making the account");
        Account acc = newAccount();
        System.out.println("Account created successfully");
        while (true) {
            System.out.println("Hello " + acc.getUsername() + " or " + acc.getEmail());
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
                break;
            } else {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Input the username and password to continue");
            System.out.println("Username: ");
            String username = input.nextLine();
            System.out.println("Password: ");
            String password = input.nextLine();
            if (username.equals(acc.getUsername()) && password.equals(acc.getPassword())) {
                System.out.println("Account successfully logged in.");
                break;
            } else {
                System.out.println("Invalid username or password");
            }
        }




    }
    public static Account newAccount(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = input.nextLine();
        System.out.println("Enter your phone number: ");
        String phoneNumber = input.nextLine();
        System.out.println("Enter your email: ");
        String email = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        System.out.println("Enter your new account number: ");
        String accountNumber = input.nextLine();
        double balance = 0.0d;
        return new Account(userName, balance, accountNumber, password, email, phoneNumber);
    }
}
