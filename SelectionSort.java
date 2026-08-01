import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[10];
        int i, j, n, min, temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        n = sc.nextInt();

        System.out.println("Enter elements ");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // selection sort

        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
                temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }

        System.out.println("Elements in an array after selection sort is ");
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
