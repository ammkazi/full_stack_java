import java.util.Vector;

public class UnderstandVector {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>(5, 3);
        v.add(10);
        v.add(21);
        v.add(30);
        v.add(51);

        for (int e : v) {
            if (e % 2 == 1) {
                System.out.println(e + " is odd");
            }
        }

        System.out.println("Elements in vector are: " + v);
        System.out.println("Size of vector is: " + v.size());
        System.out.println("Capacity of vector is: " + v.capacity());
        System.out.println("First element of vector is: " + v.firstElement());
        System.out.println("Last element of vector is: " + v.lastElement());
        v.clear();
        System.out.println("Elements in vector after clear() are: " + v);
        System.out.println("Is vector empty? " + v.isEmpty());

    }
}
