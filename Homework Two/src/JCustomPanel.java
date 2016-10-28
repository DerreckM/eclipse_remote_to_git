import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

/*
* Name     : Derreck Mansheim
 * Depaul#  : 4457125
 * Class    : SE 450
 * Homework : #2
 * Problem  : LectureTwo
 * Due Date : 09/26/2016
 *
 * class LectureTwo
 *
 */

public class JCustomPanel extends JPanel
{
  	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Shape> shapes = null;

	public JCustomPanel()
	{
	}
	
	public void paint(Graphics g) 
  	{
		Dimension dimension = getSize();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, dimension.width, dimension.height);
		
		if (shapes != null)
		{
			Iterator<Shape> iShapes = shapes.iterator();
			while (iShapes.hasNext())
			{
				iShapes.next().draw(g);
			}
		}
    }  	
	
	public void setShapes(ArrayList<Shape> shapeList)
	{
		//note:
		//Since we are not 'cloning' this list we are merely holding a reference to it
		//eventually we will 'synchronize' access to it and use a better pattern
		shapes = shapeList;
	}

}
      