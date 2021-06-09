//*************************************
// Casey McCullough
// NightSky.java
// shows random array of buildings
//
// ************************************

import java.awt.*;      
import javax.swing.*;
import java.util.Random;

public class NightSky extends JFrame {

 private static final int APPLET_WIDTH = 1000;
 private static final int APPLET_HEIGHT = 400;
 private static final int GROUND_LEVEL = 50;
 private static final int MIN_HEIGHT = 20;
 private static final int MIN_WIDTH = 25;
 private static final int NUM_STARS = 800;
 private static final int NUM_BUILDINGS = 15;
 
 private static final String CITY_NAME = "Cleveland";

 private static Building [] cityBuildings;
 private static Star[] stars;
 
  public static void main(String args[])
 {
    // C - Create and display the window. Use YOUR class name, not SampleGraphics!
    NightSky gp = new NightSky();
    gp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gp.setTitle("Night Sky by Casey McCullough");   // Optional title
    gp.setSize(APPLET_WIDTH,APPLET_HEIGHT);     // Set the width and height of the window
    
    
    Random generator = new Random();
    int count;
    int x, y, height, width;
    
    gp.setBackground (new Color (177, 177, 255));
    
    cityBuildings = new Building [NUM_BUILDINGS];
    for (count = 0; count < NUM_BUILDINGS; count++)
      // populates each Building with its values
    {
      x = generator.nextInt(APPLET_WIDTH) - MIN_WIDTH;
      height = generator.nextInt(APPLET_HEIGHT - 200) + 50;
      // height has minimum of 50, maximum of 50 short of top of applet.
      y = APPLET_HEIGHT - GROUND_LEVEL  - height;
      width = generator.nextInt(150) + 50;
      cityBuildings [count] = new Building (x, y, width, height);
    }
    
    stars = new Star[NUM_STARS];
    for (count = 0; count < NUM_STARS; count++)
    {
     x = generator.nextInt(APPLET_WIDTH);
     y = generator.nextInt(APPLET_HEIGHT - GROUND_LEVEL);
     stars [count] = new Star (x, y);
    }
    
    gp.setVisible(true);     // Display the window
    
 } // end main()
 
 
   public void paint( Graphics g ) {
  
     // produces a series of rectangles that shift sky color
     // from 0, 0, 0  (black) to 127, 127, 255 (blue)
     for (int j = 0; j < 256 / 2; j++)
     {
       g.setColor(new Color(j, j,  2 * j));
       g.fillRect(0, j * 3 , APPLET_WIDTH, 3);    
     }
     // Draws the sun
     g.setColor(new Color (250, 100, 100));
     g.fillOval(120, 90, 50, 50);
     
     for (int i = 0; i < NUM_BUILDINGS; i++)
     {
       cityBuildings[i].draw(g);
     }
     
     for (int i = 0; i < NUM_STARS; i++)
     {
       stars[i].draw(g);
     }
     
     // Draw the ground
     g.setColor (Color.darkGray);
     g.fillRect(0, APPLET_HEIGHT - GROUND_LEVEL, APPLET_WIDTH, GROUND_LEVEL);
     
     // Name the city
     g.setColor(Color.yellow);
     g.setFont(new Font("Garamond", Font.ITALIC, 28));
     g.drawString(CITY_NAME + " at dusk", 500, 45);

   } // end paint()
          
}

