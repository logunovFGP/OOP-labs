public class Rectangle {
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int getWidth(){
        return Math.abs(x2-x1);
    }
    public int getHeight(){
        return Math.abs(y2-y1);
    }
    public Rectangle(int x1, int y1, int x2, int y2) {
        if (x2 < x1 || y2 < y1) {
            System.out.println("Неверно введены аргументы. Создан вырожденный прямоугольник.");
            this.x1 = 0;
            this.x2 = 0;
            this.y1 = 0;
            this.y2 = 0;
            return;
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle(int width, int height) {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = width;
        this.y2 = height;
    }

    public Rectangle() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    public void rectPrint() {
        System.out.println("Левый верхний угол: (" + this.x1 + ", " + this.y1 + ")\nПравый нижний угол: (" + this.x2 + ", " + this.y2 + ")");
    }

    public void move(int dx, int dy) {
        this.x1 += dx;
        this.y1 += dy;
        this.x2 += dx;
        this.y2 += dy;
    }

    public Rectangle Union(Rectangle rect) {
        int x1 = Math.min(this.x1, rect.x1);
        int y1 = Math.min(this.y1, rect.y1);
        int x2 = Math.max(this.x2, rect.x2);
        int y2 = Math.max(this.y2, rect.y2);
        return new Rectangle(x1, y1, x2, y2);
    }
}
