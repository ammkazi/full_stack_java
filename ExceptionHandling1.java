import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n1, n2;
            int result;

            System.out.println("Enter n1 ");
            n1 = sc.nextInt();

            System.out.println("Enter n2 ");
            n2 = sc.nextInt();

            result = n1 / n2;
            System.out.println("Result : " + result);
        } catch (InputMismatchException i) {
            System.out.println("Enter numerical values...");
        } catch (ArithmeticException ae) {
            System.out.println("Denominator should a positive non-zero number...");
        } catch (Exception e) {
            System.out.println("OOPS .. Something went wrong...");
        } finally {
            sc.close();
            System.out.println("End of code..");
        }
    }
}
