import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Circle extends Shape
{
	//Read only pattern
	private int nColor;
	
	public Circle(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, float nColor)
	{
		super(nLeft, nTop, nRight, nBottom, nX, nY, nRotation, nColor);
	}
	
	@Override
	public void draw(Graphics graphics) 
	{
  		Ellipse2D circle = new Ellipse2D.Float(getLeft(), getTop(), getWidth(), getHeight());
		
  		Graphics2D g2d = (Graphics2D)(graphics);
  		nColor = (int) getColor();
  		g2d.setPaint(new Color(nColor));
  		//g2d.setPaint(Color.BLUE);
  		g2d.draw(circle);
	}
	
	public float getRadius()
	{
		return ((getLeft() + getRight()) / 2) - getLeft();
	}
	
	public final Point2D.Float getCenter()
	{
		return new Point2D.Float((getLeft() + getRight()) / 2.0f, (getTop() + getBottom()) / 2.0f);
	}
}
      