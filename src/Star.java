import java.awt.*;

public class Star
{
 private int xPos;
 private int yPos;
 private Color myColor;
 
 public Star (int x, int y)
 {
  xPos = x;
  yPos = y;
  myColor = Color.yellow;
  
 }
 
 public void draw (Graphics g)
 {
   g.setColor (myColor);
   g.fillRect(xPos, yPos, 1, 1);
 }
 
}
