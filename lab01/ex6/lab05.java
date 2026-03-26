package ex6;

import java.util.Scanner;
import java.util.Arrays;

public class lab05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("So phan tu mang ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        double avg = (double) sum / n;

        System.out.println(Arrays.toString(arr));
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
    }
}