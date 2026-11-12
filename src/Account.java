import java.util.Scanner;

public class Account {

    private String username;
    private double balance;
    private int accNumber;
    private String password;
    private String email;
    private int phoneNumber;


    Account(String username, double userBalance, String password, String userEmail, int phoneNumber) {
        int phoneNL = (String.valueOf(phoneNumber).length() - 2);
        int accountNumber = (int) ((int) phoneNumber % Math.pow(100, phoneNL));
        this.username = username;
        balance = userBalance;
        this.accNumber = accountNumber;
        this.password = password;
        email = userEmail;
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds() {
        Scanner input = new Scanner(System.in);
        System.out.println("Deposit Funds initiated");
        System.out.println(getUsername()+ " Current balance is: " + balance);
        try{
            System.out.println("How much do you want to deposit");
            String bbalance = input.nextLine();
            double newBalance = Double.parseDouble(bbalance);
            balance += newBalance;
            System.out.println("Deposit successful," + getUsername() + " new balance: $" + balance);
        } catch (NumberFormatException e){
            System.out.println("Invalid input");
        }

    }

    public void withdrawFunds() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("To continue input the password");
            String pin =  input.nextLine();
            if (pin.equals(password)) {
                System.out.println("Withdraw Funds initiated");
                System.out.println(getUsername()+ " Total balance is: " + balance);
                try {
                    System.out.println(getUsername() + " How much do want to withdraw");
                    String bbalance = input.nextLine();
                    double newBalance = Double.parseDouble(bbalance);
                    if (newBalance <= 0) {
                        System.out.println("Amount must be positive");
                        return;
                    }
                    if (newBalance <= balance) {
                        balance -= newBalance;
                        System.out.println("Withdrawn successful, " + getUsername() + " Current balance is: $" + balance);
                        break;
                    } else {
                        System.out.println("Insufficient funds to make transactions");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }

            }
            System.out.println("Wrong password");
            System.out.println("press enter to try again...");
            input.nextLine();
            continue;

        }
    }

    public void editUser() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("To continue input the password");
            String pin = input.nextLine();
            if (pin.equals(password)) {
                System.out.println("What do you want to edit " + getUsername());
                System.out.println("1.Username, 2.Password, 3. Phone Number, 4.E-mail\n5.Account number 6.EXIT");
                String userInfo = input.nextLine();
                if (userInfo.equals("1")){
                    System.out.println("What do you want to be the new user name");
                    String newUserName = input.nextLine();
                    setUsername(newUserName);
                    System.out.println("change Completed" + getUsername());
                } else if (userInfo.equals("2")){
                    System.out.println("What do you want to be the new user password.");
                    String newPin = input.nextLine();
                    setPassword(newPin);
                    System.out.println("change Completed");
                } else if (userInfo.equals("3")){
                    System.out.println("What do you want to be the new user phone number.");
                    String nPhoneNumber = input.nextLine();
                    int newPhoneNumber = Integer.parseInt(nPhoneNumber);
                    setPhoneNumber(newPhoneNumber);
                    System.out.println("change Completed to " + getPhoneNumber());
                } else if (userInfo.equals("4")){
                    System.out.println("What do you want to be the new user email.");
                    String newEmail = input.nextLine();
                    setEmail(newEmail);
                    System.out.println("change Completed to "+ getEmail());
                } else if (userInfo.equals("5")){
                    System.out.println("What do you want to be the new user account number.");
                    String nAccountNumber = input.nextLine();
                    int newAccountNumber = Integer.parseInt(nAccountNumber);
                    setAccNumber(newAccountNumber);
                    System.out.println("change Completed to " +  getAccNumber());
                } else if (userInfo.equals("6")){
                    System.out.println("Quitting");
                    break;

                }

            } else {
                System.out.println("Invalid input");
                System.out.println("press enter to try again...");
                input.nextLine();
            }
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
