import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private Date dateCreated;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        if (amount > 10000) {
            System.out.println("No amount greater than 10,000 will be deposited. Please contact the bank.");
        } else {
            balance += amount;
        }
    }

    public void printStatement(String name) {
        System.out.println("Name: " + name);
        System.out.println("Balance: $" + balance);
        System.out.println("Date created: " + dateCreated);
    }
}
