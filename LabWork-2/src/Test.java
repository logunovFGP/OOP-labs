public class Test {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(10, 15);
        Rectangle rect3 = new Rectangle(4, 5, 11, 13);

        System.out.println("\nКоординаты 1-го прямоугольника:");
        rect1.rectPrint();
        System.out.println("\nКоординаты 2-го прямоугольника:");
        rect2.rectPrint();
        System.out.println("\nКоординаты 3-го прямоугольника:");
        rect3.rectPrint();

        System.out.println("\nТестируем движение 1-го, 2-го и 3-го треугольника на (3,4), (11,17), (23,21) соответственно");
        rect1.move(3,4);
        rect2.move(11, 17);
        rect3.move(23, 21);

        System.out.println("\nКоординаты 1-го, 2-го и 3-го передвинутых прямоугольников:");
        rect2.rectPrint();
        rect3.rectPrint();
        rect1.rectPrint();

        System.out.println("\nТестируем объединение 2-го и 3-го прямоугольника");
        Rectangle union23 = rect2.Union(rect3);

        System.out.println("\nКоординаты 2-го, объединённого с 3-м, прямоугольника:");
        union23.rectPrint();

    }
}
