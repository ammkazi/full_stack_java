public class FindMinNMax {
    public static void main(String[] args) {
        int arr[] = { 5, 10, 7, 9, 2, 3, 4, 1, 6, 8 };
        int min = arr[0];
        int max = arr[0];
        int posMin = 0;
        int posMax = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                posMin = i + 1;
            }
            if (arr[i] > max) {
                max = arr[i];
                posMax = i + 1;
            }
        }
        System.out.println("Minimum value: " + min);
        System.out.println("Position of minimum value: " + posMin);
        System.out.println("Maximum value: " + max);
        System.out.println("Position of maximum value: " + posMax);
    }
}
