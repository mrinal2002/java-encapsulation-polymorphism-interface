// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();

    // Getter and Setter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Interface Loanable
interface Loanable {
    void applyForLoan();

    double calculateLoanEligibility();
}

// Subclass SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.05; // 5% interest
    }

    @Override
    public void applyForLoan() {
        System.out.println("Loan applied for Savings Account");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; // Loan eligibility is twice the balance
    }
}

// Main class to demonstrate polymorphism
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account1 = new SavingsAccount("A001", "John Doe", 1000);
        account1.deposit(500);
        System.out.println("Interest: " + account1.calculateInterest());
        System.out.println("Loan Eligibility: " + ((Loanable) account1).calculateLoanEligibility());
    }
}