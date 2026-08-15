public class ExceptionHandling2 {
    public static void main(String[] args) {
        try {
            int[] a = { 5, 10, 15, 20, 25 };
            System.out.println(a[7]);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println(a.getMessage());
        }
    }
}
