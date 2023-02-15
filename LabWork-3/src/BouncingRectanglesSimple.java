import java.awt.*;
import java.util.Formatter;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 * One rectangle bouncing inside a rectangular box. 
 * All codes in one file. Poor design!
 */
// Extends JPanel, so as to override the paintComponent() for custom rendering codes. 
public class BouncingRectanglesSimple extends JPanel {
   // Container box's width and height
   private static final int BOX_WIDTH = 800;
   private static final int BOX_HEIGHT = 600;
  
   private final int[] rectSpeedX = new int[30];   // Rectangle's speed for x and y
   private final int[] rectSpeedY = new int[30];
   private final int[] rectWidth = new int[30];
   private final int[] rectHeight = new int[30];
   
   private final Rectangle[] rectangles = new Rectangle[30];
   {
	   for(int i = 0; i<rectangles.length; i++)
		{
			rectWidth[i] = ThreadLocalRandom.current().nextInt(40, 70);
			rectHeight[i] = ThreadLocalRandom.current().nextInt(40, 70);
			
			if(i<10)
				rectangles[i] = new Rectangle (rectWidth[i], rectHeight[i]);
			else if (i<20)
				rectangles[i] = new DrawableRectangle (rectWidth[i], rectHeight[i], Color.GREEN);
			else
				rectangles[i] = new ColoredRect (rectWidth[i], rectHeight[i], Color.RED, Color.gray);
			
			rectSpeedX[i] = ThreadLocalRandom.current().nextInt(1,6);
			rectSpeedY[i] = ThreadLocalRandom.current().nextInt(1,6);
		}
   }
   
  
   private static final int UPDATE_RATE = 30; // Number of refresh per second
  
   /** Constructor to create the UI components and init game objects. */
   public BouncingRectanglesSimple() {
      this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
  
      // Start the rectangle bouncing (in its own thread)
      Thread gameThread = new Thread() {
         public void run() {
            while (true) {

			   for( int i =0; i<rectangles.length; i++)
			   {
					Rectangle currentRect = rectangles[i];

                    int speedX = rectSpeedX[i];
					if (currentRect.x1 +  speedX< 0
                    || (currentRect.x2 + speedX  > BOX_WIDTH)) {
                        rectSpeedX[i] = -speedX;
                    }
					// May cross both x and y bounds
					if (currentRect.y1 + rectSpeedY[i] < 0
                    || (currentRect.y2 + rectSpeedY[i] > BOX_HEIGHT)) {
						rectSpeedY[i] = -rectSpeedY[i];
					}
                    rectangles[i].move(rectSpeedX[i], rectSpeedY[i]);
				}
               // Refresh the display
               repaint(); // Callback paintComponent()
               // Delay for timing control and give other threads a chance
               try {
                  Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
               } catch (InterruptedException ex) { }
            }
         }
      };
      gameThread.start();  // Callback run()
   }
  
   /** Custom rendering codes for drawing the JPanel */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background

      g.setColor(Color.BLACK);
      g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
      g.setColor(Color.BLUE);
	  for(Rectangle rect : rectangles)
	  {
          if(rect instanceof DrawableRectangle){
              ((DrawableRectangle)rect).draw(g);
          }
	  }
	  
	  
   }
}
