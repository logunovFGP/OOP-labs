package test.sixth;

import java.util.Arrays;
import java.util.Scanner;

public class Lab1_Task6 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите число: ");
            try {
                int input = in.nextInt();
                printPrimeNumbers(input);
            }
            catch (Throwable t) {
                System.out.println("Это не валидное число");
            }

        }
        private static void printPrimeNumbers(int n){
            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = false; isPrime[1] = false;
            for (int i = 2; i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i; i * j <= n; j++) {
                        isPrime[i * j] = false;
                    }
                }
            }
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    System.out.println(i + " ");
                }
            }
        }
}
