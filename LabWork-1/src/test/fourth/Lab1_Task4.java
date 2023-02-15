package test.fourth;

public class Lab1_Task4 {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            int a = 1;
            int b = 1;
            int c = 0;
            if(n < 3){
                for(int i = 0; i < n; i++) {
                    System.out.print(1 + " ");
                }
            } else {
                System.out.print(1 + " ");
                System.out.print(1 + " ");
                for (int i = 3; i <= n; i++) {
                    c = a + b;
                    a = b;
                    b = c;
                    System.out.print(c + " ");
                }
            }

        }
        catch (Throwable t) {
            System.out.println("Это не валидное число");
        }

    }
}
