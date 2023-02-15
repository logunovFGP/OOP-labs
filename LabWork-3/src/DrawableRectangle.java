import java.awt.*;
public class DrawableRectangle extends Rectangle {
    public Color outColor;

    public DrawableRectangle(){
        super();
        outColor = Color.GREEN;
    }
    public DrawableRectangle(int width, int height, Color outColor){
        super(width, height);
        if(outColor == null){
            outColor = Color.GREEN;
        } else {
            this.outColor = outColor;
        }
    }
    public DrawableRectangle(int x, int y, int width, int height, Color outColor) {
        super(x, y, width, height);
        this.outColor = outColor;
    }
    public void draw(Graphics g) {
        g.setColor(this.outColor);
        g.drawRect(this.x1, this.y1, getWidth(), getHeight());
    }
}
