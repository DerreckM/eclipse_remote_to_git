import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Triangle extends Shape {
   private Line tLeft, tRight, tBottom;
	
    //I initially did this wrong. I found out that the 4 points that we are passing are x1,y1 and x2,y2 and a line is drawn from
     //x1, y1 coordinate to x2, y2 coordinate. Here, nLeft (left) = x1, nTop(top) = y1, nRight (right) = x2 , nBottom (bottom) = y2.   
	public Triangle(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, float nColor) {
		super(nLeft, nTop, nRight, nBottom, nX, nY, nRotation, nColor);
		tLeft = new Line(nLeft, nTop,(nRight-nLeft)/2,nBottom, nX,nY,nRotation,nColor);
		tRight = new Line((nRight-nLeft)/2,nBottom,nRight,nBottom,nX,nY,nRotation,nColor);
		tBottom = new Line(nLeft,nTop,nRight,nBottom,nX,nY,nRotation,nColor);
	}
	
	@Override
	public void draw(Graphics g) 
	{
  		
  		tLeft.draw(g);
  		tRight.draw(g);
  		tBottom.draw(g);
	}
	
	// We have to override move method as Triangle consists of 3 Lines.
	// In the below method, we will move all the three sides of triangle
	@Override
	public void move(float x, float y) {
		tLeft.move(x, y);
		tRight.move(x, y);
		tBottom.move(x, y);
	}
}