class Animal {
    protected String name;
    protected int age;
    protected double weight;
    protected String breed;

    // constructor with params
    public Animal(String name, int age, double weight, String breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    public void accept() {
    }

    public void display() {
        System.out.println("Name is " + name);
        System.out.println("Age is " + age);
    }
}

class Dog extends Animal {
    private boolean isFriendly;

    public Dog(String name, int age, double weight, String breed, boolean isFriendly) {
        // constructor chaining
        super(name, age, weight, breed);
        this.isFriendly = isFriendly;
    }
}

class Tiger extends Animal {
    private boolean isManEater;

    public Tiger(String name, int age, double weight, String breed, boolean isManEater) {
        super(name, age, weight, breed);
        this.isManEater = isManEater;
    }

}

public class Inheritance1 {
    public static void main(String[] args) {
        Dog obj1 = new Dog("Tommy", 4, 19.32, "Labrador", true);
        Tiger obj2 = new Tiger("Shera", 5, 99.21, "Bengal Tiger", false);

        obj1.display();
        obj2.display();
    }
}
