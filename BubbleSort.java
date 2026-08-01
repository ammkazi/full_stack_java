import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner sc = new Scanner(System.in);
        int i, j, temp, n;

        System.out.println("Enter n ");
        n = sc.nextInt();

        System.out.println("Enter the elements of an array ");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // bubble sort
        System.out.println("Performing Bubble Sort..");
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        // Display the elements after bubble sort
        System.out.println("Elements in an array after bubble sort is ");
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
