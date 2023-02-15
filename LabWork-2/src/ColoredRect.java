import java.awt.*;

public class ColoredRect extends DrawableRectangle {
    public Color inColor;

    public ColoredRect(){
        super();
        this.inColor = Color.RED;
    }
    public ColoredRect(int x1, int y1, int x2, int y2, Color outColor, Color inColor) {
        super(x1, y1, x2, y2, outColor);
        if(inColor == null){
            this.inColor = Color.RED;
        } else {
            this.inColor = inColor;
        }

    }
    public ColoredRect(int width, int height, Color outColor, Color inColor) {
        super(width, height, outColor);
        if(inColor == null){
            this.inColor = Color.RED;
        } else {
            this.inColor = inColor;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(inColor);
        g.fillRect(this.x1, this.y1, getWidth(), getHeight());
    }
}
