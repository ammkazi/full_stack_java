// an abstract class is a class which contains abstract methods 
// and it can also contain non abstract methods
// you cannot create object of abstract class
// you can inherit abstract class

abstract class Account {
    protected int accNo;
    protected String holdersName;
    protected double balance;
    public static int counter = 0;

    public Account(String holdersName, double balance) {
        this.accNo = ++counter;
        this.holdersName = holdersName;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    @Override
    public String toString() {
        return "Account [accNo=" + accNo + ", holdersName=" + holdersName + ", balance=" + balance + "]";
    }
}

class SavingAccount extends Account {

    protected double interestRate;
    protected double minBalance;

    public SavingAccount(String holdersName, double balance, double interestRate) {
        super(holdersName, balance);
        this.interestRate = interestRate;
        this.minBalance = 5000;
    }

    public void withdraw(double amount) {
        if ((balance - amount) >= minBalance) {
            balance = balance - amount;
            System.out.println("New Balance is : " + this.balance);
        } else {
            System.out.println("Insufficient funds..Maintain min balance of rs 5000.");
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("New Balance is : " + this.balance);
    }

}

public class AbstractClass {
    public static void main(String[] args) {
        // reference of the base class - object of the derived class
        // dynamic method dispatch

        Account obj1 = new SavingAccount("Aiman Kazi", 10000, 3.5);
        System.out.println(obj1.toString());

        obj1.deposit(10000);
        obj1.withdraw(16000);

        Account obj2 = new SavingAccount("Inshira Achwa", 100000, 3.5);
        System.out.println(obj2.toString());
        obj2.withdraw(50000);

    }
}
