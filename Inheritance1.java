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
}

class Dog extends Animal {
    private boolean isFriendly;

    public Dog(String name, int age, double weight, String breed, boolean isFriendly) {
        // constructor chaining
        super(name, age, weight, breed);
        this.isFriendly = isFriendly;
    }

    public String toString() {
        return "Dog [name=" + name + ", age=" + age + ", weight=" + weight + ", breed=" + breed + ", isFriendly="
                + isFriendly + "]";
    }

}

class Tiger extends Animal {
    private boolean isManEater;

    public Tiger(String name, int age, double weight, String breed, boolean isManEater) {
        super(name, age, weight, breed);
        this.isManEater = isManEater;
    }

    public String toString() {
        return "Tiger [name=" + name + ", age=" + age + ", weight=" + weight + ", breed=" + breed + ", isManEater="
                + isManEater + "]";
    }
}

class Elephant extends Animal {
    protected boolean inZoo;

    public Elephant(String name, int age, double weight, String breed, boolean inZoo) {
        super(name, age, weight, breed);
        this.inZoo = inZoo;
    }

    @Override
    public String toString() {
        return "Elephant [name=" + name + ", age=" + age + ", weight=" + weight + ", breed=" + breed + ", inZoo="
                + inZoo + "]";
    }

}

public class Inheritance1 {
    public static void main(String[] args) {
        Dog obj1 = new Dog("Tommy", 4, 19.32, "Labrador", true);
        Tiger obj2 = new Tiger("Shera", 5, 99.21, "Bengal Tiger", false);
        Elephant obj3 = new Elephant("Laila", 16, 47, "African", false);
        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
        System.out.println(obj3.toString());
    }
}
