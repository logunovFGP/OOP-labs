import java.awt.*;
import java.util.Formatter;
import javax.swing.*;

public class BouncingCircleSimple extends JPanel {
   // Container box's width and height
   private static final int BOX_WIDTH = 800;
   private static final int BOX_HEIGHT = 600;
  
   private int rectSpeedX = 3;   // Rectangle's speed for x and y
   private int rectSpeedY = 2;
   
   private ColoredRect colorRect = new ColoredRect(50, 20, new Color(350), new Color(220));
   
   
  
   private static final int UPDATE_RATE = 30; // Number of refresh per second
  
   /** Constructor to create the UI components and init game objects. */
   public BouncingCircleSimple() {
      this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));

      Thread gameThread = new Thread() {
         public void run() {
            while (true) {

               if (colorRect.x1 + rectSpeedX < 0
                       || (colorRect.x2 + rectSpeedX  > BOX_WIDTH)) {
                  rectSpeedX = -rectSpeedX;
               }
               if (colorRect.y1 + rectSpeedX < 0
                       || (colorRect.y2 + rectSpeedX > BOX_HEIGHT)) {
                  rectSpeedY = -rectSpeedY;
               }
				colorRect.move(rectSpeedX, rectSpeedY);
               repaint();
               try {
                  Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
               } catch (InterruptedException ex) { }
            }
         }
      };
      gameThread.start();
   }
  
   /** Custom rendering codes for drawing the JPanel */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background
  
      // Draw the box
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
  
      // Draw the rectangle
      g.setColor(Color.BLUE);
	  colorRect.draw(g);
      
      // Display the rectangle's information
      g.setColor(Color.WHITE);
      g.setFont(new Font("Courier New", Font.PLAIN, 12));
      StringBuilder sb = new StringBuilder();
      Formatter formatter = new Formatter(sb);
      formatter.format("Rectangle(%d,%d, %d,%d) Speed=(%d,%d)", colorRect.x1, colorRect.y1, colorRect.x2, colorRect.y2, rectSpeedX, rectSpeedY);
      g.drawString(sb.toString(), 20, 30);
   }
}
