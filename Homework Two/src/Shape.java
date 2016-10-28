import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements IShape
{
	private float left   = 0.0f;
	private float top    = 0.0f;
	private float right  = 0.0f;
	private float bottom = 0.0f;
	private float x 	 = 0.0f;
	private float y		 = 0.0f;
	private float rotation  = 0.0f;
	private float color;
	
	//Read only pattern
	public Shape(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, float nColor)
	{
		left   = nLeft;
		top    = nTop;
		right  = nRight;
		bottom = nBottom;
		x = nX;
		y = nY;
		rotation = nRotation;
		color = nColor;
	}
	
	public float getLeft()
	{
		return left;
	}
	
	public float getTop()
	{
		return top;
	}
	
	public float getRight()
	{
		return right;
	}
	
	public float getBottom()
	{
		return bottom;
	}
	
	public float getWidth()
	{
		return getRight() - getLeft();
	}
	
	public float getHeight()
	{
		return getBottom() - getTop();
	}
	
	public float getX() 
	{
		return x;
	}
	
	public float getY() 
	{
		return y;
	}
	
	public float getRotation() 
	{
		return rotation;
	}
	
	public float getColor() 
	{
		return color;
	}
	@Override
	public void move(float x, float y) 
	{
		left   += x;
		top    += y;
		right  += x;
		bottom += y;
	}

	@Override
	public abstract void draw(Graphics g);
}
      