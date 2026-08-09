import java.util.Scanner;

interface ICricket {
    public void bat(String hand);

    public void bowl(String hand);

    public void feild();
}

class Person {
    protected String name;
    protected int age;
    Scanner sc = new Scanner(System.in);

    public void accept() {
        System.out.println("Enter name and age ");
        name = sc.next();
        age = sc.nextInt();
    }

}

class Cricketer extends Person implements ICricket {
    protected String team;
    protected double salary;

    public void accept() {
        super.accept();
        System.out.println("Enter team and salary ");
        team = sc.next();
        salary = sc.nextDouble();
    }

    public void bat(String hand) {
        System.out.println("Bat with " + hand + " hand");
    }

    public void bowl(String hand) {
        System.out.println("Bowl with " + hand + " hand");

    }

    public void feild() {
        System.out.println("Fielding to win...");
    }

    @Override
    public String toString() {
        return "Cricketer [name=" + name + ", age=" + age + ", team=" + team + ", salary=" + salary + "]";
    }

}

public class MultipleInheritance {
    public static void main(String[] args) {
        Cricketer kohli = new Cricketer();
        kohli.accept();
        kohli.bat("Right");
        kohli.bowl("Right");
        kohli.feild();
        System.out.println(kohli.toString());
    }
}
