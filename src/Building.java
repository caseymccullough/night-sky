//********************************************************
// Building.java
// from LLC programming assignment 4.9
//
//********************************************************

import java.awt.*;
import java.util.Random;

public class Building
{

 private static final int WINDOW_SIZE = 2;
 private static final double LIT_PROBABILITY = .8;
 private static final int WINDOW_GAP = 2; 
 private static final int BUILDING_EDGE = 3;
 
 private int width;
 private int height;
 private int xPos;
 private int yPos;
 
 private Color buildingColor;
 private Color windowColor;
 private Color borderColor;

 
 public Building (int x, int y, int wid, int ht)
 {
 
  xPos = x;
  yPos = y;
  width = wid;
  height = ht;
  buildingColor = Color.black;
  windowColor = Color.yellow;
  borderColor = Color.lightGray;
 }
 
 
 public void draw (Graphics page)
 {
  Random generator = new Random ();
  
  int horizExcess = width % (WINDOW_SIZE + 2);
  int vertExcess = height % (WINDOW_SIZE + 2);
  
  int horizStart = xPos + horizExcess / 2 + 2;
  int vertStart = yPos + vertExcess / 2 + 2;
  
  
  
  // draw the building
  page.setColor(buildingColor);
  page.fillRect(xPos, yPos, width, height);
  
  
  // draws edge around building that allows it to be distinguished from others
  page.setColor (borderColor);
  page.drawRect(xPos, yPos, width, height);
  
    
  // Doing the windows . . . 
  for (int horiz = horizStart; horiz + WINDOW_SIZE <=  xPos + width; horiz += (WINDOW_SIZE + 2))
   for (int vert = vertStart; vert + WINDOW_SIZE  <= yPos + height; vert += (WINDOW_SIZE + 2))
   // the + 2 pushes each window two pixels from one another.
   {
    for (int i = 0; i < 100000; i++); 
    // slight delay between drawing each window
    
    if (generator.nextDouble() < LIT_PROBABILITY)
     page.setColor (windowColor);
    else
     page.setColor (Color.darkGray);
    
    page.fillRect (horiz, vert, WINDOW_SIZE, WINDOW_SIZE);
   
   }
     
 }
 
 
}