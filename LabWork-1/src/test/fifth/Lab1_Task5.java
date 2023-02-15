package test.fifth;

import java.util.Scanner;

public class Lab1_Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        try {
            int input = in.nextInt();
            printFactorial(input);
        }
        catch (Throwable t) {
            System.out.println("Это не валидное число");
        }
    }
    private static void printFactorial(int number) {
        final int[] factorial = {1};
        Thread t1 = new Thread(() -> {
            for (int i = number; i > 0; i -= 2) {
                factorial[0] *= i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = number - 1; i > 0; i -= 2) {
                factorial[0] *= i;
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Факториал числа " + number + " равен " + factorial[0]);
    }
}

