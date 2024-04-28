import java.util.Scanner;

// BankAccount class to represent the user's bank account
class Account {
    double balance;

    public Account(double Bal) {
        balance = Bal;
    }

    public double getBal() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        return true;
    }
}

// ATM class to interact with the user and bank account
public class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount= scanner.nextDouble();
                if (account.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;
            case 3:
                System.out.println("Your balance is: $" + account.getBal());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void main(String[] args) {
        Account account = new Account(1000); // Initial balance $1000
        ATM atm = new ATM(account);

        while (true) {
            atm.displayOptions();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            atm.processTransaction(option);
        }
    }
}
